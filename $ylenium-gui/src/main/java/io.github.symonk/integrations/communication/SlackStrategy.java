package io.github.symonk.integrations.communication;

import io.github.symonk.common.enumerations.CommunicationChannel;
import lombok.extern.slf4j.Slf4j;
import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;

import javax.inject.Inject;

@Slf4j
public class SlackStrategy implements Communicatable {

  private final SlackApi api;

  @Inject
  public SlackStrategy(final SlackApi api) {
    this.api = api;
  }

  @Override
  public void NotifyChannel(final String message) {
    log.info("Sending message to configured slack channel...");
    api.call(new SlackMessage(message));
  }

  @Override
  public CommunicationChannel getType() {
    return CommunicationChannel.SLACK;
  }
}
