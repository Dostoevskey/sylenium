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
    sy.registerConfigObserver(dummy);
    Assert.assertEquals(sy.getCfgObserversCount(), 1);
    sy.unregisterConfigObserver(dummy);
    Assert.assertEquals(sy.getCfgObserversCount(), 0);
  }

  @Test
  public void canUpdateAndGetProperties() {
    final String random = "random";
    sy.updateProperty(random, random);
    Assert.assertEquals(sy.getProperty(random), random);
  }

  @Test
  public void canReadLanguageResource() {
    Assert.assertEquals(sy.localisedValueOf("one"), "1");
  }

  @Test
  public void canRegisterTestDataToTheWorld() {
    sy.registerWorldObject(new DummyWorldObject());
    Assert.assertEquals(sy.getWorldSize(), 1);
  }

  @Test
  public void startingSyleniumReturnsValidPageObject() {
    final DummyWorldObject po = sy.start("https://www.google.com", DummyWorldObject.class);
    Assert.assertNotNull(po);
    Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "https://www.google.com/");
  }
}
