package io.symonk.sylenium.unit;

import io.symonk.sylenium.DummyWorldObject;
import io.symonk.sylenium.SyleniumWorld;
import org.testng.Assert;
import org.testng.annotations.Test;

@SuppressWarnings("unchecked")
public class SyleniumWorldTest {

  private SyleniumWorld world = new SyleniumWorld();

  @Test
  public void registeringObjects() {
    world.registerObject(new DummyWorldObject());
    Assert.assertEquals(world.getWorldSize(), 1);
  }

  @Test
  public void cleaningUpEmptiesTheWorld() {
    world.registerObject(new DummyWorldObject());
    world.cleanUpWorld();
    Assert.assertEquals(world.getWorldSize(), 0);
  }
}
