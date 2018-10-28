package io.symonk.sylenium.integration;

import io.symonk.sylenium.ResourceReader;
import io.symonk.sylenium.ex.NoSuchLocalisedPropertyException;
import io.symonk.sylenium.impl.PropertyManager;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResourceReaderIT {

  private final PropertyManager cfgManager = new PropertyManager();
  private ResourceReader resourceReader = new ResourceReader(cfgManager);

  @Test
  public void runtimeChangesToLanguageFileAreAccurate() {
    setLocalisationFile("english.properties");
    setLocalisationFile("jibberish.properties");
    assertThat(resourceReader.localisedValueOf("tango")).isEqualTo("orange");

  }

  @Test(expectedExceptions = NoSuchLocalisedPropertyException.class)
  public void noSuchPropertyThrowsNoSuchLocalisedPropertyException() {
    setLocalisationFile("english.properties");
    assertThat(resourceReader.localisedValueOf("n0p3")).isEqualTo("1");
  }

  @Test
  public void updatingLanguageViaSetterWorks() {
    setLocalisationFile("jibberish.properties");
    assertThat(resourceReader.localisedValueOf("tango")).isEqualTo("orange");
  }

  private void setLocalisationFile(final String value) {
    cfgManager.updateProperty("sy.localisation.file", value);
  }
}
