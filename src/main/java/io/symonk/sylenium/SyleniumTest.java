package io.symonk.sylenium;

import org.testng.annotations.AfterMethod;

public class SyleniumTest {

  protected Sylenium sy = Sylenium.INSTANCE;


  @AfterMethod
  public void removeObservers() {
    sy.cleanUpWorld();
  }

}
