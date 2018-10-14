package io.github.symonk.integrations.communication;

import com.google.inject.Inject;
import io.github.symonk.common.enumerations.CommunicationChannel;
import io.github.symonk.common.interfaces.Communicatable;
import org.slf4j.Logger;

public class Communicator {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Communicator.class);
    private final Communicatable strategy;
  private boolean isEnabled = false;

  @Inject
  public Communicator(final Communicatable strategy) {
    this.strategy = strategy;
    if(strategy.getType() != CommunicationChannel.NONE) isEnabled = true;
  }

  public void notify(final String message) {
      if(!isEnabled) return;
      strategy.notifyChannel(message);
  }


}
