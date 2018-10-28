package io.symonk.sylenium.unit;

import io.symonk.sylenium.DummyConfigObserver;
import io.symonk.sylenium.impl.PropertyManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PropertyManagerTest {

  private PropertyManager cfgManager;

  @BeforeMethod
  public void prep() {
    cfgManager = new PropertyManager();
  }

  @Test
  public void canRegisterObserver() {
    cfgManager.registerObserver(new DummyConfigObserver());
    Assert.assertEquals(cfgManager.getObserverCount(), 1);
    assertThat(cfgManager.getObserverCount()).isEqualTo(1);
  }

  @Test
  public void canUnregisterObserver() {
    final DummyConfigObserver dummy = new DummyConfigObserver();
    cfgManager.registerObserver(dummy);
    cfgManager.removeObserver(dummy);
    assertThat(cfgManager.getObserverCount()).isEqualTo(0);
  }

  @Test
  public void canSetAndGetProperty() {
    cfgManager.updateProperty("setter", "setter");
    assertThat(cfgManager.getProperty("setter")).isEqualTo("setter");
  }

}
