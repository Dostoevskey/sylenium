package io.symonk.sylenium.testng;

import io.symonk.sylenium.Sylenium;
import io.symonk.sylenium.SyleniumTestCase;
import io.symonk.sylenium.types.SyleniumTestCaseResult;
import org.testng.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SyleniumTestNg implements IExecutionListener, ISuiteListener {

   private  Map<SyleniumTestCase, SyleniumTestCaseResult> mapOfTestsToBeExecuted = new ConcurrentHashMap<>();
   private Sylenium sy = Sylenium.INSTANCE;


    @Override
    public void onExecutionStart() {
        System.out.println("Test Execution has began!");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("Test Execution has finished");
    }

    @Override
    public void onStart(ISuite iSuite) {
        iSuite.getAllMethods().forEach(m -> System.out.println(m.getMethodName()));
        try {
            Thread.sleep(1000);
        } catch(Exception ex) {}
    }

    @Override
    public void onFinish(ISuite iSuite) {

        iSuite.getResults().forEach((k,v) -> {
            System.out.println("Result:");
            v.getTestContext().getPassedTests().getAllMethods().forEach(m -> System.out.println(m.getMethodName()));
        });
    }
}
