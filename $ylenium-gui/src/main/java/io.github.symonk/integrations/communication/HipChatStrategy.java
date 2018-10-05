package io.github.symonk.integrations.communication;

import io.evanwong.oss.hipchat.v2.HipChatClient;
import io.github.symonk.common.enumerations.CommunicationChannel;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;

@Slf4j
public class HipChatStrategy implements Communicatable {

  private final HipChatClient api;

  @Inject
  public HipChatStrategy(final HipChatClient api) {
    this.api = api;
  }

  @Override
  public void NotifyChannel(final String message) {
    log.info("Sending message to configured hipchat channel..");
  }

  @Override
  public CommunicationChannel getType() {
    return CommunicationChannel.HIPCHAT;
  }
}
