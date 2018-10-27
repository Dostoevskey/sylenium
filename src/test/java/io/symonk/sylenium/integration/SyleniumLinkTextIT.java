package io.symonk.sylenium.integration;

import com.codeborne.selenide.Condition;
import io.symonk.sylenium.DummyWorldObject;
import io.symonk.sylenium.SyleniumTest;
import org.testng.annotations.Test;


public class SyleniumLinkTextIT extends SyleniumTest {

    @Test
    public void canFindExactLinkTextElement() {
        sylenium.launch("http://toolsqa.com/automation-practice-form/", DummyWorldObject.class);
        sylenium.$localisedLinkText("link.text").shouldBe(Condition.visible);
    }

    @Test
    public void canFindListOfExactTextElements() {
        sylenium.launch("http://toolsqa.com/automation-practice-form/", DummyWorldObject.class);
        sylenium.$$localisedLinkText("link.text").shouldHaveSize(1);
    }


    @Test
    public void canFindPartialLinkTextElement() {
        sylenium.launch("http://toolsqa.com/automation-practice-form/", DummyWorldObject.class);
        sylenium.$localisedPartialLinkText("multiple.link.text").shouldBe(Condition.visible);
    }

    @Test
    public void canFindListOfPartialTextElements() {
        sylenium.launch("http://toolsqa.com/automation-practice-form/", DummyWorldObject.class);
        sylenium.$$localisedPartialLinkText("multiple.link.text").shouldHaveSize(11);
    }
}
