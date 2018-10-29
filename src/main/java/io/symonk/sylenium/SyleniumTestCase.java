package io.symonk.sylenium;

import io.symonk.sylenium.types.SyleniumTestCaseResult;

public interface SyleniumTestCase {

    String retrieveName();
    SyleniumTestCaseResult retrieveResult();
}
