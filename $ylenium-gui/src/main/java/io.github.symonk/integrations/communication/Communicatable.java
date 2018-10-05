package io.github.symonk.integrations.communication;


import io.github.symonk.common.enumerations.CommunicationChannel;

public interface Communicatable {

    void NotifyChannel(final String message);
    CommunicationChannel getType();

}
