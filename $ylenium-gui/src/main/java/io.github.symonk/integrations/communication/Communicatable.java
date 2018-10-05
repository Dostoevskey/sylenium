package io.github.symonk.integrations.communication;

import io.github.symonk.common.enumerations.CommunicationChannel;
import net.gpedro.integrations.slack.SlackException;

public interface Communicatable {

  void NotifyChannel(final String message) throws SlackException;

  CommunicationChannel getType();
}
