package io.symonk.sylenium.integration;

import io.symonk.sylenium.SyleniumTest;
import io.symonk.sylenium.ex.NoSuchLanguageFileException;
import io.symonk.sylenium.ex.NoSuchLocalisedPropertyException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocalisationTest extends SyleniumTest {

  @Test(expectedExceptions = NoSuchLanguageFileException.class)
  public void noLocalisationFileThrowsNoSuchLanguageFileException() {
    setLocalisationFile("made-up.properties");
    sylenium.localisedValueOf("fail");
  }

  @Test
  public void validLocalisationFileCanReadProperty() {
    setLocalisationFile("english.properties");
    Assert.assertEquals(sylenium.localisedValueOf("one"), "1");
  }

  @Test
  public void runtimeChangesToLanguageFileAreAccurate() {
    setLocalisationFile("english.properties");
    Assert.assertEquals(sylenium.localisedValueOf("one"), "1");
    setLocalisationFile("jibberish.properties");
    Assert.assertEquals(sylenium.localisedValueOf("tango"), "orange");
  }

  @Test(expectedExceptions = NoSuchLocalisedPropertyException.class)
  public void noSuchPropertyThrowsNoSuchLocalisedPropertyException() {
    setLocalisationFile("english.properties");
    Assert.assertEquals(sylenium.localisedValueOf("n0p3"), "1");
  }

  @Test
  public void updatingLanguageViaSetterWorks() {
    setLocalisationFile("jibberish.properties");
    Assert.assertEquals(sylenium.localisedValueOf("tango"), "orange");
  }

  private void setLocalisationFile(final String value) {
    sylenium.setProperty("$y.localisation.file", value);
  }
}
