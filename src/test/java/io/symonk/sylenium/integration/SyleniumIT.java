package io.symonk.sylenium.integration;

import com.codeborne.selenide.WebDriverRunner;
import io.symonk.sylenium.DummyConfigObserver;
import io.symonk.sylenium.DummyWorldObject;
import io.symonk.sylenium.SyleniumTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SyleniumIT extends SyleniumTest {

  @Test
  public void canRegisterAndRemoveObservers() {
    final DummyConfigObserver dummy = new DummyConfigObserver();
    sylenium.registerConfigObserver(dummy);
    Assert.assertEquals(sylenium.getCfgObserversCount(), 1);
    sylenium.unregisterConfigObserver(dummy);
    Assert.assertEquals(sylenium.getCfgObserversCount(), 0);
  }

  @Test
  public void canSetGetAndRemoveProperties() {
    final String random = "random";
    sylenium.setProperty(random, random);
    Assert.assertEquals(sylenium.getProperty(random), random);
    sylenium.removeProperty(random);
    Assert.assertEquals(sylenium.getProperty(random), "");
  }

  @Test
  public void canReadLanguageResource() {
    Assert.assertEquals(sylenium.localisedValueOf("one"), "1");
  }

  @Test
  public void canRegisterTestDataToTheWorld() {
    sylenium.registerWorldObject(new DummyWorldObject());
    Assert.assertEquals(sylenium.getWorldSize(), 1);
  }

  @Test
  public void startingSyleniumReturnsValidPageObject() {
    final DummyWorldObject po = sylenium.launch("https://www.google.com", DummyWorldObject.class);
    Assert.assertNotNull(po);
    Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "https://www.google.com/");
  }
}
