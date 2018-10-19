package io.github.symonk.integrations.communication;


import io.github.symonk.common.enumerations.CommunicationChannel;
import io.github.symonk.common.interfaces.Communicatable;
import org.slf4j.Logger;

public class NoChatStrategy implements Communicatable {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(NoChatStrategy.class);

    @Override
    public void notifyChannel(final String message) {
        log.info("Communication has not been configured in the framework properties");
    }

    @Override
    public CommunicationChannel getType() {
        return CommunicationChannel.NONE;
    }
}
