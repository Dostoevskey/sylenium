package io.symonk.sylenium;

import io.symonk.sylenium.contracts.ConfigObserver;
import io.symonk.sylenium.contracts.SyleniumConfig;

import java.util.logging.Logger;

public class DummyConfigObserver implements ConfigObserver {

  private static final Logger log = Logger.getLogger(DummyConfigObserver.class.getName());

  @Override
  public void update(final SyleniumConfig config) {
      // do nothing for now
  }
}
