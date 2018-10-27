package io.symonk.sylenium;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SyleniumPartialLinkText {

    private SyleniumPartialLinkText() {}

    public static By syLinkText(final String languageKey) {
        return new By() {
            @Override
            public List<WebElement> findElements(final SearchContext searchContext) {
                return searchContext.findElements(By.partialLinkText(languageKey));
            }

            @Override
            public WebElement findElement(final SearchContext searchContext) {
                return searchContext.findElement(By.partialLinkText(languageKey));
            }
            @Override
            public String toString() {
                return "By localised partial linktext";
            }
        };
    }
}
