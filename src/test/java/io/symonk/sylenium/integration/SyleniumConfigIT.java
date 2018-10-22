package io.symonk.sylenium.integration;

import io.symonk.sylenium.impl.ConfigManager;
import io.symonk.sylenium.impl.LocalisationFileReader;
import io.symonk.sylenium.Sylenium;
import io.symonk.sylenium.ex.NoSuchLanguageFileException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SyleniumConfigIT {

  private ConfigManager configManager;
  private Sylenium sy;

  @BeforeTest
  public void setup() {
    sy = new Sylenium();
    configManager = new ConfigManager();
  }

  @Test
  public void canGetAndSetProperty() {
    configManager.setProperty("$y.localisation.file", "ok.properties");
    Assert.assertEquals(configManager.getProperty("$y.localisation.file"), "ok.properties");
  }

  @Test(expectedExceptions = NoSuchLanguageFileException.class)
  public void configIsUpdatedForRegisteredObservers() {
    final LocalisationFileReader one = new LocalisationFileReader();
    final LocalisationFileReader two = new LocalisationFileReader();
    configManager.registerObserver(one);
    configManager.registerObserver(two);
    sy.setProperty("$y.localisation.file", "dumbo.properties");
    one.getLanguageValue("wont-exist.properties");
  }

  @Test
  public void canAddNewProperty() {
    configManager.setProperty("i.am.new", "hello");
    Assert.assertEquals(configManager.getProperty("i.am.new"), "hello");
  }

  @Test
  public void canRemoveAProperty() {
    final String rmprop = "removed.prop";
    configManager.setProperty(rmprop, "hello");
    configManager.removeProperty(rmprop);
    Assert.assertEquals(configManager.getProperty(rmprop), "");

  }

}
