package io.symonk.sylenium;

import org.testng.annotations.BeforeMethod;

public class SyleniumTest {

  protected Sylenium sy = Sylenium.INSTANCE;


  @BeforeMethod
  public void cleaningUp() {
    sy.cleanUpWorld();
  }
}
