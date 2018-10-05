package io.github.symonk.listeners;

import io.github.symonk.configurations.properties.FrameworkProperties;
import io.github.symonk.integrations.communication.Communicator;
import io.github.symonk.integrations.communication.SlackStrategy;
import lombok.extern.slf4j.Slf4j;
import net.gpedro.integrations.slack.SlackApi;
import org.aeonbits.owner.ConfigFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class NotificationListener implements ITestListener {

  public static final AtomicInteger testsPassed = new AtomicInteger(0);
  public static final AtomicInteger testsFailed = new AtomicInteger(0);
  private final Communicator communicator =
      new Communicator(
          new SlackStrategy(
              new SlackApi(
                  ConfigFactory.create(FrameworkProperties.class).communicationWebHook())));

  @Override
  public void onTestStart(final ITestResult iTestResult) {
    communicator.notify("Test run started");
  }

  @Override
  public void onTestSuccess(final ITestResult iTestResult) {
    //
  }

  @Override
  public void onTestFailure(final ITestResult iTestResult) {
    communicator.notify("Test Failure! " + iTestResult.getName());
    testsFailed.incrementAndGet();
  }

  @Override
  public void onTestSkipped(final ITestResult iTestResult) {
    //
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(final ITestResult iTestResult) {
    //
  }

  @Override
  public void onStart(final ITestContext iTestContext) {
    //
  }

  @Override
  public void onFinish(final ITestContext iTestContext) {
    communicator.notify("Test run finished!");
  }
}
