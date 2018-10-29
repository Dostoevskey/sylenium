package io.symonk.sylenium.types;

import java.util.Arrays;
import java.util.Optional;

public enum SyleniumTestCaseResult {

    PASSED(1),
    FAILED(2),
    SKIPPED(3),
    UNKNOWN(4);

    private final int result_code;

    SyleniumTestCaseResult(final int result_code) {
        this.result_code = result_code;
    }

    public int getResultCode() {
        return result_code;
    }

    public static Optional<SyleniumTestCaseResult> valueOf(int value) {
        return Arrays.stream(values())
                .filter(id -> id.result_code == value)
                .findFirst();
    }

    @Override
    public String toString() {
        return this.name();
    }
}
