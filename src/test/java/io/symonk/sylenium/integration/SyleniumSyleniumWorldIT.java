package io.symonk.sylenium.integration;

import io.symonk.sylenium.SyleniumTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SyleniumSyleniumWorldIT extends SyleniumTest {

  @Test
  public void registerWorldObject() {
    sylenium.register(new DummyWorldObject());
    Assert.assertEquals(sylenium.getWorldSize(), 1);
  }

  @Test
  public void canCleanUpTheWorld() {
    sylenium.register(new DummyWorldObject());
    sylenium.cleanUpWorld();
    Assert.assertEquals(sylenium.getWorldSize(), 0);
  }
}
