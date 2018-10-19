package io.github.symonk.integrations.communication;

import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.hipchat.api.HipChat;
import ch.viascom.hipchat.api.models.Notification;
import ch.viascom.hipchat.api.models.message.MessageColor;
import io.github.symonk.common.enumerations.CommunicationChannel;
import io.github.symonk.common.exceptions.SyleniumCommunicationException;
import io.github.symonk.common.interfaces.Communicatable;
import org.slf4j.Logger;

import javax.inject.Inject;

public class HipChatStrategy implements Communicatable {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(HipChatStrategy.class);
    private final HipChat api;
  private final String channel;

  @Inject
  public HipChatStrategy(final HipChat api, final String channel) {
    this.api = api;
    this.channel = channel;
  }

  @Override
  public void notifyChannel(final String message) {
    log.info("Sending message to configured hip chat channel..");
    try {
    api.roomsApi().sendRoomNotification("Sylenium", new Notification(null, null, MessageColor.RED, null, true, message, null));
    } catch(final FoxHttpException exception) {
      throw new SyleniumCommunicationException(exception);
    }
  }

  @Override
  public CommunicationChannel getType() {
    return CommunicationChannel.HIPCHAT;
  }
}
