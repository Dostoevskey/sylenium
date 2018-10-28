package io.symonk.sylenium.unit;

import io.symonk.sylenium.DummyWorldObject;
import io.symonk.sylenium.SyleniumWorld;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("unchecked")
public class SyleniumWorldTest {

  private SyleniumWorld world = new SyleniumWorld();

  @Test
  public void registeringObjects() {
    world.registerObject(new DummyWorldObject());
    assertThat(world.getWorldSize()).isEqualTo(1);
  }

  @Test
  public void unregisteringObjects() {
    final DummyWorldObject obj = new DummyWorldObject();
    world.registerObject(obj);
    world.unregisterObject(obj);
    assertThat(world.getWorldSize()).isEqualTo(0);
  }

  @Test
  public void cleaningUpEmptiesTheWorld() {
    world.registerObject(new DummyWorldObject());
    world.cleanUpWorld();
    assertThat(world.getWorldSize()).isEqualTo(0);
  }
}
