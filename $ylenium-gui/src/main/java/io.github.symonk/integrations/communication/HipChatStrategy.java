package io.github.symonk.integrations.communication;

import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.hipchat.api.HipChat;
import ch.viascom.hipchat.api.models.Notification;
import ch.viascom.hipchat.api.models.message.MessageColor;
import io.github.symonk.common.enumerations.CommunicationChannel;
import io.github.symonk.common.exceptions.$yCommunicationException;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;

@Slf4j
public class HipChatStrategy implements Communicatable {

  private final HipChat api;

  @Inject
  public HipChatStrategy(final HipChat api) {
    this.api = api;
  }

  @Override
  public void NotifyChannel(final String message) {
    log.info("Sending message to configured hip chat channel..");
    try {
    api.roomsApi().sendRoomNotification("2640607", new Notification(null, null, MessageColor.RED, null, true, "Hello World", null));
    } catch(FoxHttpException exception) {
      throw new $yCommunicationException(exception);
    }
  }

  @Override
  public CommunicationChannel getType() {
    return CommunicationChannel.HIPCHAT;
  }
}
