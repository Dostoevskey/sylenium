package io.symonk.sylenium;

import io.symonk.sylenium.interfaces.ConfigObserver;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.List;

public class BaseIT {

  protected Sylenium sy = Sylenium.INSTANCE;
  protected List<ConfigObserver> testObservers = new ArrayList<>();
  private final Server server = new Server();

  @BeforeSuite
  public void startJettyServer() throws Exception {

  }

  @BeforeMethod
  public void setupObservers() {
    testObservers.add(new DummyConfigObserver());
    testObservers.add(new DummyConfigObserver());
    testObservers.add(new DummyConfigObserver());
  }

  @AfterMethod
  public void removeObservers() {
    sy.cleanUpWorld();
  }

  @AfterSuite
  public void stopJettyServer() throws Exception {
    server.stop();
  }
}
