package io.symonk.sylenium.integration;

import io.symonk.sylenium.impl.ConfigManager;
import io.symonk.sylenium.Sylenium;
import io.symonk.sylenium.ex.NoSuchLanguageFileException;
import io.symonk.sylenium.ex.NoSuchLocalisedPropertyException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LocalisationIT {

  private ConfigManager configManager;
  private Sylenium sy;

  @BeforeTest
  public void setup() {
    sy = new Sylenium();
    configManager = new ConfigManager();
  }

  @Test(expectedExceptions = NoSuchLanguageFileException.class)
  public void noLocalisationFileThrowsNoSuchLanguageFileException() {
    setLocalisationFile("made-up.properties");
    sy.localisedValueOf("fail");
  }

  @Test
  public void validLocalisationFileCanReadProperty() {
    setLocalisationFile("english.properties");
    Assert.assertEquals(sy.localisedValueOf("one"), "1");
  }

  @Test
  public void runtimeChangesToLanguageFileAreAccurate() {
    setLocalisationFile("english.properties");
    Assert.assertEquals(sy.localisedValueOf("one"), "1");
    setLocalisationFile("jibberish.properties");
    Assert.assertEquals(sy.localisedValueOf("tango"), "orange");
  }

  @Test(expectedExceptions = NoSuchLocalisedPropertyException.class)
  public void noSuchPropertyThrowsNoSuchLocalisedPropertyException() {
    setLocalisationFile("english.properties");
    Assert.assertEquals(sy.localisedValueOf("n0p3"), "1");
  }

  @Test
  public void updatingLanguageViaSetterWorks() {
    setLocalisationFile("jibberish.properties");
    Assert.assertEquals(sy.localisedValueOf("tango"), "orange");
  }

  private void setLocalisationFile(final String value) {
    sy.setProperty("$y.localisation.file", value);
  }
}
