package io.symonk.sylenium;

import io.symonk.sylenium.interfaces.ConfigObserver;
import io.symonk.sylenium.interfaces.SyleniumConfig;

import java.util.logging.Logger;

public class DummyConfigObserver implements ConfigObserver {

  private static final Logger log = Logger.getLogger(DummyConfigObserver.class.getName());

  @Override
  public void update(final SyleniumConfig config) {
    log.info("Updating dummy config observer");
  }
}
