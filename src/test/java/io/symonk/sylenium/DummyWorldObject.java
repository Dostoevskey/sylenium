package io.symonk.sylenium;

import io.symonk.sylenium.interfaces.SyleniumObject;

public class DummyWorldObject implements SyleniumObject {

  @Override
  public void cleanUp() {
    System.out.println("Cleaning up dummy test data object");
  }
}
