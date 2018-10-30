package io.symonk.sylenium.integration;

import com.codeborne.selenide.WebDriverRunner;
import groovy.util.logging.Slf4j;
import io.symonk.sylenium.BaseIT;
import io.symonk.sylenium.DummyWorldObject;
import io.symonk.sylenium.annotation.CaseID;
import io.symonk.sylenium.annotation.CaseDescription;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SyleniumIT extends BaseIT {

  @Test
  @CaseDescription("Sylenium can register new config observers and remove them")
  @CaseID(100)
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
