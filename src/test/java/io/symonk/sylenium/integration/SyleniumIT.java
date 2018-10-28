package io.symonk.sylenium.integration;

import com.codeborne.selenide.WebDriverRunner;
import io.symonk.sylenium.BaseIT;
import io.symonk.sylenium.DummyWorldObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
    assertThat(sy.getProperty("sy.enable.localisation")).isEqualTo("true");
  }

  @Test
  public void canReadLanguageResource() {
    assertThat(sy.localisedValueOf("one")).isEqualTo("1");
  }

  @Test
  public void canRegisterTestDataToTheWorld() {
    sy.registerWorldObject(new DummyWorldObject());
    assertThat(sy.getWorldItemCount()).isEqualTo(1);
  }

  @Test
  public void startingSyleniumReturnsValidPageObject() {
    final DummyWorldObject po = sy.start(DummyWorldObject.class);
    assertThat(po).isNotNull();
    assertThat(WebDriverRunner.getWebDriver().getCurrentUrl()).isEqualTo("http://toolsqa.com/automation-practice-form/");
  }
}
