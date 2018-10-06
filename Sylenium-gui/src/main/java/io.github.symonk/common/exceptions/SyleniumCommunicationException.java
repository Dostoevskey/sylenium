package io.github.symonk.common.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SyleniumCommunicationException extends RuntimeException {

    public SyleniumCommunicationException(final Exception exception) {
        super(exception);
        log.error("Exception occurred: {} ", exception.getMessage());
    }

}
