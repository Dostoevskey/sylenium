package io.symonk.sylenium.model;


import io.symonk.sylenium.types.SyleniumTestCaseResult;

public class SyleniumTestModel {

    private final String caseName;
    private final int caseId;
    private SyleniumTestCaseResult result = SyleniumTestCaseResult.UNKNOWN;

    public SyleniumTestModel(final String caseName, final int caseId) {
        this.caseName = caseName;
        this.caseId = caseId;
    }

    public void setResult(final SyleniumTestCaseResult result) {
        this.result = result;
    }

    public String getCaseName() {
        return this.caseName;
    }

    @Override
    public String toString() {
        return "name: " + caseName + " | " + "caseId: " + caseId + " | " + "result: " + result;
    }

}
