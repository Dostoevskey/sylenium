package io.symonk.sylenium.stubs;

import io.symonk.sylenium.interfaces.ConfigObserver;
import io.symonk.sylenium.interfaces.SyleniumConfig;

import java.util.logging.Logger;

public class DummyConfigObserver implements ConfigObserver {

  private static final Logger log = Logger.getLogger(DummyWorldObject.class.getName());

  @Override
  public void update(final SyleniumConfig config) {
    log.info("Updating dummy config observer");
  }
}
