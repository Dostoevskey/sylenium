package io.symonk.sylenium.testng;


import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.List;

public class ExecutionResult {

    private List<ITestResult> passed = new ArrayList<>();
    private List<ITestResult> failed = new ArrayList<>();
    private List<ITestResult> skipped = new ArrayList<>();

    public ExecutionResult() {

    }

    public void displayResults() {

    }


}
