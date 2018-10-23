package io.symonk.sylenium.integration;

import io.symonk.sylenium.SyleniumTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SyleniumIT extends SyleniumTest {

  @Test
  public void startingWithPoInitialisesPage() {
    final DummyWorldObject po = sylenium.start("https://www.google.com", DummyWorldObject.class);
    Assert.assertNotNull(po);
  }
}
