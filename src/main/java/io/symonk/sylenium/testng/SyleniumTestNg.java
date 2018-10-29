package io.symonk.sylenium.testng;

import io.symonk.sylenium.Sylenium;
import io.symonk.sylenium.annotation.$y;
import io.symonk.sylenium.model.SyleniumTestModel;
import io.symonk.sylenium.types.SyleniumTestCaseResult;
import org.testng.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static io.symonk.sylenium.SyleniumAsciiParser.parseAscii;

public class SyleniumTestNg implements IExecutionListener, ISuiteListener, ITestListener {

    private List<SyleniumTestModel> testCases = Collections.synchronizedList(new ArrayList<>());
    private Sylenium sy = Sylenium.INSTANCE;

    @Override
    public void onExecutionStart() {
        parseAscii();
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("Well that was easy wasen't it? Thanks for using Sylenium!");
    }

    @Override
    public void onStart(ISuite iSuite) {
        System.out.println("Sylenium has detected an execution of the suite: " + iSuite.getName());
        System.out.println("Total tests to be executed as part of this suite: " + iSuite.getAllMethods().size());
    }

    @Override
    public void onFinish(ISuite iSuite) {
        System.out.println("Suite: " + iSuite.getName() + " has finished.");
        testCases.forEach(test -> System.out.println(test.toString()));
    }

    @Override
    public void onTestStart(final ITestResult iTestResult) {
        final Method testMethod = iTestResult.getMethod().getConstructorOrMethod().getMethod();
        final String name = getTestCaseSyleniumName(testMethod);
        final int id = getTestCaseSyleniumId(testMethod);
        if (!name.isEmpty() && id != 0) {
            testCases.add(new SyleniumTestModel(name, id));
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

    private String getTestCaseSyleniumName(final Method testMethod) {
        return Optional.of(testMethod.getAnnotation($y.class).caseName()).orElse("");
    }

    private int getTestCaseSyleniumId(final Method testMethod) {
        return Optional.of(testMethod.getAnnotation($y.class).caseId()).orElse(0);
    }

    private void updateResultForSyleniumTest(final String testName, final int status) {
        testCases.forEach(
                e -> {
                    if (e.equals(testName))
                        e.setResult(
                                SyleniumTestCaseResult.valueOf(status).orElse(SyleniumTestCaseResult.UNKNOWN));
        });
    }

    private SyleniumTestCaseResult getResultStatus(final int id) {
        return SyleniumTestCaseResult.valueOf(id).orElse(SyleniumTestCaseResult.UNKNOWN);
    }
}
