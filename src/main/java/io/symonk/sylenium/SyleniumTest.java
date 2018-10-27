package io.symonk.sylenium;

import org.testng.annotations.BeforeMethod;

public class SyleniumTest {

  protected Sylenium sylenium = Sylenium.INSTANCE;


  @BeforeMethod
  public void cleaningUp() {
    sylenium.cleanUpWorld();
  }
}
