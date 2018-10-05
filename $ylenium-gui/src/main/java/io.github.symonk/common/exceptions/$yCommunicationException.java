package io.github.symonk.common.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class $yCommunicationException extends RuntimeException {

    public $yCommunicationException(final Exception exception) {
        super(exception);
        log.error("Exception occurred: {} ", exception.getMessage());
    }

}
