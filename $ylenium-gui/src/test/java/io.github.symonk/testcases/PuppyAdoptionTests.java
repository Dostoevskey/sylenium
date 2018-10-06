package io.github.symonk.testcases;

import io.github.symonk.common.helpers.localisation.ProvidesLanguageValues;
import io.github.symonk.configurations.guice.GuiceModule;
import io.github.symonk.data.OrderProvidable;
import io.github.symonk.models.PuppyOrder;
import io.github.symonk.listeners.TestExecutionListener;
import io.github.symonk.pageobjects.pages.PuppyAdoptionHomePage;
import io.qameta.allure.*;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.inject.Inject;

@Slf4j
@Epic("Puppy Adoption Epic")
@Feature("Puppy Adoption Process Feature")
@Guice(modules = GuiceModule.class)
@Listeners({TestExecutionListener.class})
public class PuppyAdoptionTests extends TestBaseTemplate {

  private final OrderProvidable orderProvider;
  private final PuppyAdoptionHomePage puppyAdoptionHomePage;

  @Inject
  public PuppyAdoptionTests(final ProvidesLanguageValues languageHelper, final OrderProvidable orderProvider, final PuppyAdoptionHomePage puppyAdoptionHomePage) {
    super(languageHelper);
    this.puppyAdoptionHomePage = puppyAdoptionHomePage;
    this.orderProvider = orderProvider;
  }

  @Test(description = "Hannah can be adopted")
  @Story("As a customer, I can adopt Hannah without any options")
  @Issue("ISS-001")
  @TmsLink("1")
  @Severity(SeverityLevel.CRITICAL)
  public void adoptingHannahWithoutAnyOptions() {
    puppyAdoptionHomePage
        .openPage()
        .viewHannahDetails()
        .adoptPuppy()
        .completeTheAdoption()
        .fillInOrderDetails(orderProvider.createRandomOrder())
        .messageIsDisplayed(languageHelper.getResource("successful.adoption.message"));
  }

  @Test(description = "Brook can be adopted")
  @Story("As a customer, I can adopt Brook including all options")
  @Issue("ISS-002")
  @TmsLink("2")
  @Severity(SeverityLevel.CRITICAL)
  public void adoptingBrookWithAllOptions() {
    final PuppyOrder order = orderProvider.createRandomOrderWithAllOptions();
    puppyAdoptionHomePage
        .openPage()
        .viewBrookDetails()
        .adoptPuppy()
        .completeTheAdoption(order)
        .fillInOrderDetails(order)
        .messageIsDisplayed(languageHelper.getResource("successful.adoption.message"));
  }

  @Test(description = "Cart reflects correct pricing for all options")
  @Story("As a customer, I am billed correctly for my options")
  @Issue("ISS-003")
  @TmsLink("3")
  @Severity(SeverityLevel.CRITICAL)
  public void optionsAreCorrectlyBilled() {
    final PuppyOrder order = orderProvider.createRandomOrderWithAllOptions();
    puppyAdoptionHomePage
        .openPage()
        .viewBrookDetails()
        .adoptPuppy()
        .orderPriceForAllItemsIsCorrect(
            languageHelper.getResource("total.price.all.options"), order);
  }

  @AfterClass(alwaysRun = true, description = "[Test Teardown]")
  public void afterClass() {
    log.info("This runs after each class");
  }
}
