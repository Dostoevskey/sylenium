package io.symonk.sylenium.command.browser;


import io.symonk.sylenium.SyleniumLinkText;
import io.symonk.sylenium.interfaces.SyleniumCommand;
import org.openqa.selenium.By;

public class ElementLocalisedLinkTextCommand implements SyleniumCommand<By> {

    private final String lookupKey;

    public ElementLocalisedLinkTextCommand(final String lookupKey) {
        this.lookupKey = lookupKey;
    }

    @Override
    public By execute(final Object[] args) {
        return SyleniumLinkText.syLinkText(lookupKey);
    }
}
