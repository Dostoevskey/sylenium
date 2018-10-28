package io.symonk.sylenium.integration;

import com.codeborne.selenide.Condition;
import io.symonk.sylenium.BaseIT;
import io.symonk.sylenium.DummyWorldObject;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class SyleniumLinkTextIT extends BaseIT {

    @Test
    public void canFindExactLinkTextElement() {
        sy.start(DummyWorldObject.class);
        $(sy.localisedLinkTextOf("link.text")).shouldBe(Condition.visible);
    }

    @Test
    public void canFindListOfExactTextElements() {
        sy.start(DummyWorldObject.class);
        $$(sy.localisedLinkTextOf("link.text")).shouldHaveSize(1);
    }

    @Test
    public void canFindPartialLinkTextElement() {
        sy.start(DummyWorldObject.class);
       $(sy.localisedPartialLinkTextOf("multiple.link.text")).shouldBe(Condition.visible);
    }

    @Test
    public void canFindListOfPartialTextElements() {
        sy.start(DummyWorldObject.class);
        $$(sy.localisedPartialLinkTextOf("multiple.link.text")).shouldHaveSize(11);
    }
}
