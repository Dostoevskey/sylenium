package io.symonk.sylenium;

import io.symonk.sylenium.annotation.StartUrl;
import io.symonk.sylenium.contracts.SyleniumObject;
import org.slf4j.Logger;

@StartUrl(url = "http://toolsqa.com/automation-practice-form/")
public class DummyWorldObject implements SyleniumObject {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(DummyWorldObject.class);

    @Override
  public void cleanUp() {
    log.info("Cleaning up dummy test data object");
  }
}
