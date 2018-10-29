package io.symonk.sylenium.testng;

import io.symonk.sylenium.annotation.$y;
import io.symonk.sylenium.model.SyleniumTestModel;
import io.symonk.sylenium.types.SyleniumTestCaseResult;
import lombok.extern.slf4j.Slf4j;
import org.testng.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.symonk.sylenium.SyleniumAsciiParser.parseAscii;

@Slf4j
public class SyleniumTestNg implements IExecutionListener, ISuiteListener, ITestListener {

    private List<SyleniumTestModel> testCases = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void onExecutionStart() {
        parseAscii();
    }

    @Override
    public void onExecutionFinish() {
        log.info("Well that was easy wasen't it? Thanks for using Sylenium!");
    }

    @Override
    public void onStart(ISuite iSuite) {
        log.info("Sylenium has detected an execution of the suite: " + iSuite.getName());
        log.info("Total tests to be executed as part of this suite: " + iSuite.getAllMethods().size());
    }

    @Override
    public void onFinish(ISuite iSuite) {
        log.info("Suite: " + iSuite.getName() + " has finished.");
        testCases.forEach(test -> log.info(test.toString()));
    }

    @Override
    public void onTestStart(final ITestResult iTestResult) {
        final Method testMethod = iTestResult.getMethod().getConstructorOrMethod().getMethod();
        final String name = getTestCaseSyleniumName(testMethod);
        final int id = getTestCaseSyleniumId(testMethod);
        if (doesTestMeetSyleniumRequirements(testMethod)) testCases.add(new SyleniumTestModel(name, id));
    }

    @Override
    public void onTestSuccess(final ITestResult iTestResult) {
        updateResultForSyleniumTest(iTestResult.getName(), iTestResult.getStatus());
    }

    @Override
    public void onTestFailure(final ITestResult iTestResult) {
        updateResultForSyleniumTest(iTestResult.getName(), iTestResult.getStatus());
    }

    @Override
    public void onTestSkipped(final ITestResult iTestResult) {
        updateResultForSyleniumTest(iTestResult.getName(), iTestResult.getStatus());
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
    }

    private String getTestCaseSyleniumName(final Method testMethod) {
        if (doesTestMeetSyleniumRequirements(testMethod)) {
            return getTestCasename(testMethod);
        }
        return "";
    }

    private int getTestCaseSyleniumId(final Method testMethod) {
        if (doesTestMeetSyleniumRequirements(testMethod)) {
            return getTestCaseId(testMethod);
        }
        return -1;
    }

    private void updateResultForSyleniumTest(final String testName, final int status) {
        testCases.forEach(
                e -> {
                    if (e.getCaseName().equals(testName))
                        e.setResult(
                                SyleniumTestCaseResult.valueOf(status).orElse(SyleniumTestCaseResult.UNKNOWN));
                });
    }

    private SyleniumTestCaseResult getResultStatus(final int id) {
        return SyleniumTestCaseResult.valueOf(id).orElse(SyleniumTestCaseResult.UNKNOWN);
    }

    private boolean doesTestMeetSyleniumRequirements(final Method method) {
        if (method.isAnnotationPresent($y.class)) {
            return method.getAnnotation($y.class).caseId() > 0 && !method.getAnnotation($y.class).caseName().isEmpty();
        }
        return false;
    }

    private int getTestCaseId(final Method method) {
        return method.getAnnotation($y.class).caseId();
    }

    private String getTestCasename(final Method method) {
        return method.getAnnotation($y.class).caseName();
    }
}
