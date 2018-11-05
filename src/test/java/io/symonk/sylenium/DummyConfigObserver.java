package io.symonk.sylenium;

import io.symonk.sylenium.contracts.ConfigObserver;
import io.symonk.sylenium.contracts.SyleniumConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DummyConfigObserver implements ConfigObserver {


  @Override
  public void update(final SyleniumConfig config) {
      // do nothing for now
  }
}
