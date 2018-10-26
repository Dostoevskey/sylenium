package io.symonk.sylenium.unit;

import io.symonk.sylenium.DummyConfigObserver;
import io.symonk.sylenium.impl.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ConfigManagerTest {

  private ConfigManager cfgManager;

  @BeforeMethod
  public void prep() {
    cfgManager = new ConfigManager();

  }

  @Test
  public void canRegisterObserver() {
    cfgManager.registerObserver(new DummyConfigObserver());
    Assert.assertEquals(cfgManager.getObserverCount(), 1);
  }

  @Test
  public void canUnregisterObserver() {
    final DummyConfigObserver dummy = new DummyConfigObserver();
    cfgManager.registerObserver(dummy);
    cfgManager.removeObserver(dummy);
    Assert.assertEquals(cfgManager.getObserverCount(), 0);
  }

  @Test
  public void canSetAndGetProperty() {
    cfgManager.setProperty("setter", "setter");
    Assert.assertEquals(cfgManager.getProperty("setter"), "setter");
  }

  @Test
  public void canRemoveProperty() {
    cfgManager.setProperty("remove", "remove");
    cfgManager.removeProperty("remove");
    Assert.assertEquals(cfgManager.getProperty("remove"), "");
  }
}
