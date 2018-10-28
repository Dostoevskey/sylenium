package io.symonk.sylenium.integration;

import com.codeborne.selenide.WebDriverRunner;
import io.symonk.sylenium.BaseIT;
import io.symonk.sylenium.DummyWorldObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SyleniumIT extends BaseIT {

  @Test
  public void canRegisterAndRemoveObservers() {
    sy.addConfigObserver(testObservers.get(0));
    Assert.assertEquals(sy.getConfigObserverCount(), 2);
    sy.removeConfigObserver(testObservers.get(0));
    Assert.assertEquals(sy.getConfigObserverCount(), 1);
  }

  @Test
  public void canUpdateAndGetProperties() {
    sy.updateProperty("sy.enable.localisation", "true");
    Assert.assertEquals(sy.getProperty("sy.enable.localisation"), "true");
  }

  @Test
  public void canReadLanguageResource() {
    Assert.assertEquals(sy.localisedValueOf("one"), "1");
  }

  @Test
  public void canRegisterTestDataToTheWorld() {
    sy.registerWorldObject(new DummyWorldObject());
    Assert.assertEquals(sy.getWorldItemCount(), 1);
  }

  @Test
  public void startingSyleniumReturnsValidPageObject() {
    final DummyWorldObject po = sy.start(DummyWorldObject.class);
    Assert.assertNotNull(po);
    Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "http://toolsqa.com/automation-practice-form/");
  }
}
