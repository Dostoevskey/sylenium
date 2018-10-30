package io.symonk.sylenium.testng;

import io.symonk.sylenium.annotation.CaseID;
import io.symonk.sylenium.annotation.CaseDescription;
import io.symonk.sylenium.model.SyleniumTestModel;
import io.symonk.sylenium.types.SyleniumTestCaseResult;
import lombok.extern.slf4j.Slf4j;
import org.testng.*;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

import static io.symonk.sylenium.SyleniumAsciiParser.parseAscii;

@Slf4j
public class SyleniumTestNg extends TestListenerAdapter implements IExecutionListener, ISuiteListener, ITestListener {

    private Set<SyleniumTestModel> testCases = Collections.synchronizedSet(new LinkedHashSet<>());

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
        validateTestContainsAnnotations(iTestResult);
    }


    private void validateTestContainsAnnotations(final ITestResult iTestResult) {
        final Method testMethod = iTestResult.getMethod().getConstructorOrMethod().getMethod();
        final String name = validateAndGetCaseName(testMethod);
        final int id = validateAndGetCaseId(testMethod);
        if(!name.isEmpty() && id != -1) {
            testCases.add(new SyleniumTestModel(name, id));
        } else {
            throw new SkipException("Test signature does not adhere to syleniums annotation expectations, skipping test");
        }
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

    private void updateResultForSyleniumTest(final String testName, final int status) {
        testCases.forEach(
                e -> {
                    if (e.getCaseName().equals(testName))
                        e.setResult(
                                SyleniumTestCaseResult.valueOf(status).orElse(SyleniumTestCaseResult.UNKNOWN));
                });
    }


    private int validateAndGetCaseId(final Method method) {
        return method.isAnnotationPresent(CaseID.class) && method.getAnnotation(CaseID.class).value() > 0
                ? method.getAnnotation(CaseID.class).value()
                : - 1;
    }

    private String validateAndGetCaseName(final Method method) {
        return method.isAnnotationPresent(CaseDescription.class) && !method.getAnnotation(CaseDescription.class).value().isEmpty()
                ? method.getAnnotation(CaseDescription.class).value()
                : "";
    }

}
