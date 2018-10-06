package io.github.symonk.integrations.communication;

import io.github.symonk.common.enumerations.CommunicationChannel;
import io.github.symonk.common.interfaces.Communicatable;
import lombok.extern.slf4j.Slf4j;
import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;

import javax.inject.Inject;

@Slf4j
public class SlackChatStrategy implements Communicatable {

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
