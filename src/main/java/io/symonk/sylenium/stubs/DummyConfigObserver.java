package io.symonk.sylenium.stubs;

import io.symonk.sylenium.interfaces.ConfigObserver;
import io.symonk.sylenium.interfaces.SyleniumConfig;

public class DummyConfigObserver implements ConfigObserver {

  @Override
  public void update(final SyleniumConfig config) {
    System.out.println("Updating dummy config observer");
  }
}
