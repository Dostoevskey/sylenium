package io.symonk.sylenium.testng;

import io.symonk.sylenium.Sylenium;
import io.symonk.sylenium.annotation.FlushWorld;
import org.testng.*;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SyleniumListener implements ISuiteListener, ITestListener, IInvokedMethodListener2 {

  private final Sylenium sylenium;

  public SyleniumListener() {
    this.sylenium = new Sylenium();
  }

  @Override
  public void beforeInvocation(
      final IInvokedMethod iInvokedMethod,
      final ITestResult iTestResult,
      final ITestContext iTestContext) {
    if (needsWorld(iTestResult)) {
      System.out.println("Sylenium world detected, providing a fresh world to the test: [" + iInvokedMethod.getTestMethod().getMethodName() + "]");
    }
  }

  @Override
  public void afterInvocation(
      final IInvokedMethod iInvokedMethod,
      final ITestResult iTestResult,
      final ITestContext iTestContext) {}

  @Override
  public void beforeInvocation(
      final IInvokedMethod iInvokedMethod, final ITestResult iTestResult) {}

  @Override
  public void afterInvocation(final IInvokedMethod iInvokedMethod, final ITestResult iTestResult) {}

  @Override
  public void onStart(final ISuite iSuite) {
    System.out.println("Sylenium test execution run detected!");
  }

  @Override
  public void onFinish(final ISuite iSuite) {}

  @Override
  public void onTestStart(final ITestResult iTestResult) {}

  @Override
  public void onTestSuccess(final ITestResult iTestResult) {}

  @Override
  public void onTestFailure(final ITestResult iTestResult) {}

  @Override
  public void onTestSkipped(final ITestResult iTestResult) {}

  @Override
  public void onTestFailedButWithinSuccessPercentage(final ITestResult iTestResult) {}

  @Override
  public void onStart(final ITestContext iTestContext) {}

  @Override
  public void onFinish(final ITestContext iTestContext) {}

  private boolean needsWorld(final ITestResult result) {
    return hasAnnotationOnClass(result, FlushWorld.class);
  }

  private boolean hasAnnotationOnClass(
      final ITestResult result, final Class<? extends Annotation> clazz) {
    return !getAnnotationsOnClass(result, clazz).isEmpty();
  }

  @SuppressWarnings("unchecked")
  private <T extends Annotation> List<T> getAnnotationsOnClass(
      final ITestResult result, final Class<T> clazz) {
    return Stream.of(result)
        .map(ITestResult::getTestClass)
        .filter(Objects::nonNull)
        .map(IClass::getRealClass)
        .flatMap(aClass -> Stream.of(aClass.getAnnotationsByType(clazz)))
        .map(clazz::cast)
        .collect(Collectors.toList());
  }
}
