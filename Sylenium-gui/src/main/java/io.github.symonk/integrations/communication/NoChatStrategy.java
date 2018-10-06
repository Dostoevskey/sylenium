package io.github.symonk.integrations.communication;


import io.github.symonk.common.enumerations.CommunicationChannel;
import io.github.symonk.common.interfaces.Communicatable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoChatStrategy implements Communicatable {

    @Override
    public void notifyChannel(final String message) {
        log.info("Communication has not been configured in the framework properties");
    }

    @Override
    public CommunicationChannel getType() {
        return CommunicationChannel.NONE;
    }
}
