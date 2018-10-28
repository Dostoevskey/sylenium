package io.symonk.sylenium.integration;

import com.codeborne.selenide.Condition;
import io.symonk.sylenium.DummyWorldObject;
import io.symonk.sylenium.SyleniumTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class SyleniumLinkTextIT extends SyleniumTest {

    @Test
    public void canFindExactLinkTextElement() {
        sylenium.start(DummyWorldObject.class);
        $(sylenium.).shouldBe(Condition.visible);
    }

    @Test
    public void canFindListOfExactTextElements() {
        sylenium.start("http://toolsqa.com/automation-practice-form/", DummyWorldObject.class);
        sylenium.$$localisedLinkText("link.text").shouldHaveSize(1);
    }


    @Test
    public void canFindPartialLinkTextElement() {
        sylenium.start("http://toolsqa.com/automation-practice-form/", DummyWorldObject.class);
        sylenium.$localisedPartialLinkText("multiple.link.text").shouldBe(Condition.visible);
    }

    @Test
    public void canFindListOfPartialTextElements() {
        sylenium.start("http://toolsqa.com/automation-practice-form/", DummyWorldObject.class);
        sylenium.$$localisedPartialLinkText("multiple.link.text").shouldHaveSize(11);
    }
}
