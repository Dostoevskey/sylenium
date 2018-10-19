package io.github.symonk.integrations.communication;

import io.github.symonk.common.enumerations.CommunicationChannel;
import io.github.symonk.common.interfaces.Communicatable;
import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;
import org.slf4j.Logger;

import javax.inject.Inject;

public class SlackChatStrategy implements Communicatable {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(SlackChatStrategy.class);
    private final SlackApi api;

  @Inject
  public SlackChatStrategy(final SlackApi api) {
    this.api = api;
  }

  @Override
  public void notifyChannel(final String message) {
    log.info("Sending message to configured slack channel...");
    api.call(new SlackMessage(message));
  }

  @Override
  public CommunicationChannel getType() {
    return CommunicationChannel.SLACK;
  }
}
