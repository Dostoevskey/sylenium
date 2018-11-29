package io.symonk.sylenium.ex;

import org.slf4j.Logger;
import org.testng.SkipException;

public class ContractNotMetException extends SkipException {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ContractNotMetException.class);

    public ContractNotMetException(String s) {
        super(s);
        log.error("Test was skipped because it does not adhere to Syleniums test contract");
    }
}
