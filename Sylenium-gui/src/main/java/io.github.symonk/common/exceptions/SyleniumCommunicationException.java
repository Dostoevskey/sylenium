package io.github.symonk.common.exceptions;

import org.slf4j.Logger;

public class SyleniumCommunicationException extends RuntimeException {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(SyleniumCommunicationException.class);

    public SyleniumCommunicationException(final Exception exception) {
        super(exception);
        log.error("Exception occurred: {} ", exception.getMessage());
    }

}
