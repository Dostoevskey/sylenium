package io.symonk.sylenium;

import org.testng.annotations.BeforeMethod;

public class SyleniumTest {

  protected Sylenium sylenium;

  @BeforeMethod
  public void beforeTest() {
    sylenium = new Sylenium();
  }

  @BeforeMethod
  public void cleaningUp() {
    sylenium.cleanUpWorld();
  }
}
