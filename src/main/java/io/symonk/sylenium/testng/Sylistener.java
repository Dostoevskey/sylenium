package io.symonk.sylenium.testng;

import io.symonk.sylenium.annotation.CaseDescription;
import io.symonk.sylenium.annotation.CaseID;
import io.symonk.sylenium.annotation.ConfigureLog;
import io.symonk.sylenium.model.TestContainer;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.testng.*;

import java.lang.reflect.Method;
import java.util.*;

import static io.symonk.sylenium.SyleniumOutputParserUtility.parseAscii;
import static io.symonk.sylenium.SyleniumOutputParserUtility.parseResults;

public class Sylistener extends TestListenerAdapter implements IExecutionListener, ISuiteListener, ITestListener {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Sylistener.class);
    private Set<TestContainer> testCases = Collections.synchronizedSet(new LinkedHashSet<>());
    private ThreadLocal<String> mdcLogger = new ThreadLocal<>();

    @Override
    public void onExecutionStart() {
        parseAscii();
    }

    @Override
    public void onExecutionFinish() {
        log.info("Test run has completed. Thanks for using Sylenium.");
        parseResults(testCases);
    }

    @Override
    public void onStart(ISuite iSuite) {
        log.info("Sylenium has detected an execution of the suite: " + iSuite.getName());
        log.info("Total tests to be executed as part of this suite: " + iSuite.getAllMethods().size());
        iSuite.getAllMethods().forEach(testNGMethod -> buildContainer(testNGMethod.getConstructorOrMethod().getMethod()));
    }

    private void buildContainer(final Method method) {
        final TestContainer testContainer = new TestContainer(getCaseId(method), getCaseDescription(method));
        testCases.add(testContainer);
    }

    private int getCaseId(final Method method) {
        return Arrays.stream(method.getAnnotations())
                .filter(annotation -> annotation.annotationType() == CaseID.class)
                .mapToInt(annotation -> method.getAnnotation(CaseID.class).value())
                .filter(id -> id > 0)
                .findFirst().orElse(-1);
    }

    private String getCaseDescription(final Method method) {
        return Arrays.stream(method.getAnnotations())
                .filter(annotation -> annotation.annotationType() == CaseDescription.class)
                .map(annotation -> method.getAnnotation(CaseDescription.class).value())
                .filter(description -> !description.isEmpty())
                .findFirst().orElse(method.getName());
    }


    @Override
    public void onFinish(ISuite iSuite) {
        log.info("Suite: " + iSuite.getName() + " has finished.");
    }

    @Override
    public void onTestStart(final ITestResult iTestResult) {
        final Method method =  iTestResult.getMethod().getConstructorOrMethod().getMethod();
        final boolean isFirstRun = getTestInvocationCount(iTestResult) == 0;
        final boolean splitLogs = shouldSplitLogs(method);
        String name = getUniqueLogName(method);

        if(splitLogs && !isFirstRun) name +=  "_" + getTestInvocationCount(iTestResult);

        mdcLogger.set(name);
        prepareMDCForGivenTest(mdcLogger.get());
    }

    private String getUniqueLogName(final Method method) {
        return Arrays.stream(method.getAnnotations())
                .filter(annotation -> annotation.annotationType() == ConfigureLog.class)
                .map(annotation -> (ConfigureLog) annotation)
                .map(ConfigureLog::name)
                .filter(name -> !name.isEmpty())
                .findFirst().orElse(method.getName());
    }

    private boolean shouldSplitLogs(final Method method) {
        return Arrays.stream(method.getAnnotations())
                .filter(annotation -> annotation.annotationType() == ConfigureLog.class)
                .map(anno -> (ConfigureLog) anno)
                .filter(anno -> !anno.splitLogFiles())
                .count() < 1;
    }

    private int getTestInvocationCount(final ITestResult result) {
        return result.getMethod().getCurrentInvocationCount();
    }

    private void prepareMDCForGivenTest(final String testLoggerName) {
        MDC.put("sylenium", testLoggerName);
    }

    private void removeMDCForTest(final String testLoggerName) {
        MDC.remove(testLoggerName);
    }

    @Override
    public void onTestSuccess(final ITestResult iTestResult) {
        final Method method = iTestResult.getMethod().getConstructorOrMethod().getMethod();
        testCases.forEach(tc -> {
            if (tc.getCaseDescription().equals(getCaseDescription(method))) {
                tc.setStatus(iTestResult.getStatus());
            }
        });
    }

    @Override
    public void onTestFailure(final ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(final ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(final ITestResult iTestResult) {
        // do nothing for now
    }

    @Override
    public void onStart(final ITestContext iTestContext) {
    }

    @Override
    public void onFinish(final ITestContext iTestContext) {
        removeMDCForTest(mdcLogger.get());
    }


}
