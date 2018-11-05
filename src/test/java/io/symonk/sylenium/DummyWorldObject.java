package io.symonk.sylenium;

import io.symonk.sylenium.annotation.StartUrl;
import io.symonk.sylenium.contracts.SyleniumObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@StartUrl(url = "http://toolsqa.com/automation-practice-form/")
public class DummyWorldObject implements SyleniumObject {

  @Override
  public void cleanUp() {
    log.info("Cleaning up dummy test data object");
  }
}
