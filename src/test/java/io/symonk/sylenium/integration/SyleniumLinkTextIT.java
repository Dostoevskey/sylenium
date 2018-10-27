package io.symonk.sylenium.integration;

import com.codeborne.selenide.Condition;
import io.symonk.sylenium.DummyWorldObject;
import io.symonk.sylenium.SyleniumTest;
import org.testng.annotations.Test;


public class SyleniumLinkTextIT extends SyleniumTest {

    @Test
    public void canElementByLocalisedText() {
        sylenium.launch("http://toolsqa.com/automation-practice-form/", DummyWorldObject.class);
        sylenium.$yLinkText("partial.link.text").shouldBe(Condition.visible);
    }
}
