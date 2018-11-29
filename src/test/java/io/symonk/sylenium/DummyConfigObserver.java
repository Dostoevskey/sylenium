package io.symonk.sylenium;

import io.symonk.sylenium.contracts.ConfigObserver;
import io.symonk.sylenium.contracts.SyleniumConfig;
import org.slf4j.Logger;

public class DummyConfigObserver implements ConfigObserver {


    private static final Logger log = org.slf4j.LoggerFactory.getLogger(DummyConfigObserver.class);

    @Override
  public void update(final SyleniumConfig config) {
      // do nothing for now
  }
}
