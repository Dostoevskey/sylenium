package io.github.symonk.listeners;

import com.codeborne.selenide.Configuration;
import io.github.symonk.common.helpers.reporting.ReportHelper;
import io.github.symonk.common.helpers.reporting.ReportInteractable;
import io.github.symonk.configurations.properties.FrameworkProperties;
import io.github.symonk.integrations.communication.Communicator;
import io.github.symonk.integrations.communication.SlackStrategy;
import lombok.extern.slf4j.Slf4j;
import net.gpedro.integrations.slack.SlackApi;
import org.aeonbits.owner.ConfigFactory;
import org.testng.IExecutionListener;

@Slf4j
public class TestExecutionListener implements IExecutionListener {

  private final FrameworkProperties properties = ConfigFactory.create(FrameworkProperties.class);
  private final ReportInteractable reportHelper = new ReportHelper(properties);
  private final Communicator communicator = new Communicator(new SlackStrategy(new SlackApi(properties.communicationWebHook())));

  @Override
  public void onExecutionStart() {
    log.info("test run starting!");
    configureTestRun();
    pushReportInformation();
  }

  @Override
  public void onExecutionFinish() {
    log.info("test run finished!");
    communicator.notify(
        "Total Tests Executed: "
            + NotificationListener.testsFailed
            + NotificationListener.testsPassed
            + "Passed: "
            + NotificationListener.testsPassed
            + " | "
            + "Failed: "
            + NotificationListener.testsFailed);
  }

  private void configureTestRun() {
    log.info("configuring the test run!");
    Configuration.browser = properties.selenideBrowser();
    if (properties.useSeleniumGrid()) {
      Configuration.remote = properties.seleniumGridEndpoint();
    }
    if (properties.useCustomBrowserDimensions()) {
      Configuration.startMaximized = false;
      Configuration.browserSize = properties.browserDimensions();
    }

    Configuration.baseUrl = properties.baseUrl();
    Configuration.timeout = properties.explicitWaitTimeout();
  }

  private void pushReportInformation() {
    log.info("pushing report information");
    this.reportHelper.pushDynamicTestRunPropertiesToReport();
  }
}
