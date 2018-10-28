package io.symonk.sylenium;

import io.symonk.sylenium.interfaces.ConfigObserver;
import io.symonk.sylenium.stubs.DummyConfigObserver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

public class SyleniumTest {

  protected Sylenium sy = Sylenium.INSTANCE;
  protected List<ConfigObserver> testObservers = new ArrayList<>();

  @BeforeMethod
  public void setupObservers() {
    testObservers.add(new DummyConfigObserver());
    testObservers.add(new DummyConfigObserver());
    testObservers.add(new DummyConfigObserver());
  }

  @AfterMethod
  public void removeObservers() {
    sy.cleanUpWorld();
    testObservers.forEach(obs -> sy.removeConfigObserver(obs));

  }

}
