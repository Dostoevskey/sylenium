package io.symonk.sylenium.ex;

import lombok.extern.slf4j.Slf4j;
import org.testng.SkipException;

@Slf4j
public class InvalidSyleniumTestContractException extends SkipException {

    public InvalidSyleniumTestContractException(String s) {
        super(s);
        log.error("Test was skipped because it does not adhere to Syleniums test contract");
    }
}
