package io.symonk.sylenium.stubs;

import io.symonk.sylenium.annotation.StartUrl;
import io.symonk.sylenium.interfaces.SyleniumObject;

@StartUrl(url = "http://toolsqa.com/automation-practice-form/")
public class DummyWorldObject implements SyleniumObject {

  @Override
  public void cleanUp() {
    System.out.println("Cleaning up dummy test data object");
  }
}
