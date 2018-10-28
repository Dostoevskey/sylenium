package io.symonk.sylenium;

import io.symonk.sylenium.annotation.StartUrl;
import io.symonk.sylenium.interfaces.SyleniumObject;

import java.util.logging.Logger;

@StartUrl(url = "http://toolsqa.com/automation-practice-form/")
public class DummyWorldObject implements SyleniumObject {

  private static final Logger log = Logger.getLogger(DummyWorldObject.class.getName());

  @Override
  public void cleanUp() {
    log.info("Cleaning up dummy test data object");
  }
}
