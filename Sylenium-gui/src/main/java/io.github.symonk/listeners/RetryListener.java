package io.github.symonk.listeners;

import org.slf4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {

  private static final int MAXIMUM_ATTEMPTS = 1;
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(RetryListener.class);
    private int attempts = 0;

  @Override
  public boolean retry(final ITestResult iTestResult) {
    boolean result = false;
    if (!iTestResult.isSuccess()) {
      if (attempts < MAXIMUM_ATTEMPTS) {
        attempts++;
        iTestResult.setStatus(ITestResult.FAILURE);
        result = true;
      } else {
        iTestResult.setStatus(ITestResult.FAILURE);
      }
    } else {
      iTestResult.setStatus(ITestResult.SUCCESS);
    }
    return result;
  }
}
