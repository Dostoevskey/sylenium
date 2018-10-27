package io.symonk.sylenium.integration;

import com.codeborne.selenide.Condition;
import io.symonk.sylenium.DummyWorldObject;
import io.symonk.sylenium.SyleniumTest;
import org.testng.annotations.Test;


public class SyleniumLinkTextIT extends SyleniumTest {

    @Test
    public void canFindPartialTextElementByLocalisedLookup() {
        sylenium.launch("http://toolsqa.com/automation-practice-form/", DummyWorldObject.class);
        sylenium.$localisedLinkText("partial.link.text").shouldBe(Condition.visible);
    }

    @Test
    public void canFindPartialTextElementsByLocalisedLookup() {
        sylenium.launch("http://toolsqa.com/automation-practice-form/", DummyWorldObject.class);
        sylenium.$$localisedPartialLinkText("multiple.link.text").shouldHaveSize(11);
    }
}
