package io.symonk.sylenium.integration;

import io.symonk.sylenium.SyleniumTest;
import io.symonk.sylenium.ex.NoSuchLanguageFileException;
import io.symonk.sylenium.impl.LocalisationFileReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SyleniumConfigIT extends SyleniumTest {

  @Test
  public void canGetAndSetProperty() {
    sylenium.setProperty("$y.localisation.file", "ok.properties");
    Assert.assertEquals(sylenium.getProperty("$y.localisation.file"), "ok.properties");
  }

  @Test(expectedExceptions = NoSuchLanguageFileException.class)
  public void configIsUpdatedForRegisteredObservers() {
    final LocalisationFileReader one = new LocalisationFileReader();
    final LocalisationFileReader two = new LocalisationFileReader();
    sylenium.registerConfigObserver(one);
    sylenium.registerConfigObserver(two);
    sylenium.setProperty("$y.localisation.file", "dumbo.properties");
    one.getLanguageValue("wont-exist.properties");
  }

  @Test
  public void canAddNewProperty() {
    sylenium.setProperty("i.am.new", "hello");
    Assert.assertEquals(sylenium.getProperty("i.am.new"), "hello");
  }

  @Test
  public void canRemoveAProperty() {
    final String rmprop = "removed.prop";
    sylenium.setProperty(rmprop, "hello");
    sylenium.removeProperty(rmprop);
    Assert.assertEquals(sylenium.getProperty(rmprop), "");
  }

}
