package io.github.symonk.listeners;

import com.codeborne.selenide.Configuration;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import io.github.symonk.common.interfaces.ReportInteractable;
import io.github.symonk.configurations.guice.GuiceModule;
import io.github.symonk.configurations.properties.SyleniumProperties;
import io.github.symonk.integrations.communication.Communicator;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class TestExecutionListener implements ITestListener {

  @Inject private SyleniumProperties properties;
  @Inject private ReportInteractable reportHelper;
  @Inject private Communicator communicator;

  private static final AtomicInteger testsPassed = new AtomicInteger(0);
  private static final AtomicInteger testsFailed = new AtomicInteger(0);
  private static final AtomicInteger testsSkipped = new AtomicInteger(0);

  @Override
  public void onTestStart(final ITestResult iTestResult) {
    communicate(String.format("Starting test: %s", iTestResult.getName()));
    try (BufferedReader br = new BufferedReader(new FileReader(new File(Objects.requireNonNull(getClass().getClassLoader().getResource("ascii.txt")).getFile())))) {
      String line;
      System.out.println("\n*******************************************************");
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
      System.out.println("******************************************************** \n");
    } catch (IOException e) {
      log.error("Ascii file cannot be found, continuing without it");
    }
  }

  @Override
  public void onTestSuccess(final ITestResult iTestResult) {
    communicate(String.format("Test passed: %s", iTestResult.getName()));
    testsPassed.incrementAndGet();
  }

  @Override
  public void onTestFailure(final ITestResult iTestResult) {
    communicate(String.format("Test failed: %s", iTestResult.getName()));
    testsFailed.incrementAndGet();
  }

  @Override
  public void onTestSkipped(final ITestResult iTestResult) {
    communicate(String.format("Test skipped: %s", iTestResult.getName()));
    testsSkipped.incrementAndGet();
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(final ITestResult iTestResult) {}

  @Override
  public void onFinish(final ITestContext iTestContext) {

    communicate("Test run completed");
    communicate(" -- Test Run Statistics Below -- ");
    communicate(String.format("Passed:  %s", testsPassed));
    communicate(String.format("Failed:  %s", testsFailed));
    communicate(String.format("Skipped: %s", testsSkipped));
    communicate(" --------------------------------");
  }

  @Override
  public void onStart(final ITestContext context) {
    final Injector parentInjector = context.getSuite().getParentInjector();
    final List<Module> guiceModules = context.getGuiceModules(GuiceModule.class);
    parentInjector.createChildInjector(guiceModules).injectMembers(this);

    communicate("Test run started");
    configureTestRun();
    pushReportInformation();
  }

  private void configureTestRun() {
    communicate("Configuring the test run");
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
    communicate("Pushing the report environment variables");
    this.reportHelper.pushDynamicTestRunPropertiesToReport();
  }

  private void communicate(final String message) {
    log.info(message);
    communicator.notify(message);
  }
}
