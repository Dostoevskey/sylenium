package io.symonk.sylenium.types;

public enum SyleniumTestCaseResult {

    PASSED(1),
    FAILED(2),
    SKIPPED(3);

    private final int result_code;

    SyleniumTestCaseResult(final int result_code) {
        this.result_code = result_code;
    }

    public int getResultCode() {
        return result_code;
    }

}
