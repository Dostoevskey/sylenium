package io.github.symonk.integrations.communication;

import com.google.inject.Inject;
import io.github.symonk.common.enumerations.CommunicationChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Communicator {

  private final Communicatable strategy;
  private boolean isEnabled = false;

  @Inject
  public Communicator(final Communicatable strategy) {
    this.strategy = strategy;
    if(strategy.getType() != CommunicationChannel.NONE) isEnabled = true;
  }

  public void notify(final String message) {
      if(!isEnabled) {
        log.error("You have not configured the communications channel correctly, setup configurations in the framework.properties");
        return;
      }
      strategy.NotifyChannel(message);
  }


}
