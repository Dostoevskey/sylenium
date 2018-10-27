package io.symonk.sylenium;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SyleniumLinkText {

  public static By syLinkText(final String languageKey) {
    return new By() {
      @Override
      public List<WebElement> findElements(final SearchContext searchContext) {
        return searchContext.findElements(By.linkText(languageKey));
      }

      @Override
      public WebElement findElement(final SearchContext searchContext) {
        return searchContext.findElement(By.linkText(languageKey));
      }
      @Override
      public String toString() {
        return "By localised linktext";
      }
    };
  }

}
