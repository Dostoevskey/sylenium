package io.symonk.sylenium.integration;

import io.symonk.sylenium.ResourceReader;
import io.symonk.sylenium.ex.NoSuchLocalisedPropertyException;
import io.symonk.sylenium.impl.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResourceReaderIT {

  private final ConfigManager cfgManager = new ConfigManager();
  private ResourceReader resourceReader = new ResourceReader(cfgManager);

  @Test
  public void runtimeChangesToLanguageFileAreAccurate() {
    setLocalisationFile("english.properties");
    setLocalisationFile("jibberish.properties");
    Assert.assertEquals(resourceReader.localisedValueOf("tango"), "orange");
  }

  @Test(expectedExceptions = NoSuchLocalisedPropertyException.class)
  public void noSuchPropertyThrowsNoSuchLocalisedPropertyException() {
    setLocalisationFile("english.properties");
    Assert.assertEquals(resourceReader.localisedValueOf("n0p3"), "1");
  }

  @Test
  public void updatingLanguageViaSetterWorks() {
    setLocalisationFile("jibberish.properties");
    Assert.assertEquals(resourceReader.localisedValueOf("tango"), "orange");
  }

  private void setLocalisationFile(final String value) {
    cfgManager.setProperty("$y.localisation.file", value);
  }
}
