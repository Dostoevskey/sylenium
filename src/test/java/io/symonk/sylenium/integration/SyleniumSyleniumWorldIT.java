package io.symonk.sylenium.integration;

import io.symonk.sylenium.Sylenium;
import io.symonk.sylenium.annotation.FlushWorld;
import io.symonk.sylenium.testng.SyleniumListener;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@FlushWorld
@Listeners(SyleniumListener.class)
public class SyleniumSyleniumWorldIT {

  private Sylenium sy;

  @BeforeTest
  public void setup() {
    sy = new Sylenium();
  }

  @Test
  public void registerWorldObject() {
    sy.register(new DummyWorldObject());
    Assert.assertEquals(sy.getWorldSize(), 1);
  }

  @Test
  public void canCleanUpTheWorld() {
    sy.register(new DummyWorldObject());
    sy.cleanUpWorld();
    Assert.assertEquals(sy.getWorldSize(), 0);
  }
}
