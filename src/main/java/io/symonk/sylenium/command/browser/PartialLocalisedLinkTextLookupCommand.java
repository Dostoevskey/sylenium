package io.symonk.sylenium.command.browser;

import io.symonk.sylenium.SyleniumPartialLinkText;
import io.symonk.sylenium.interfaces.SyleniumCommand;
import org.openqa.selenium.By;

public class PartialLocalisedLinkTextLookupCommand implements SyleniumCommand<By> {


  @Override
  public By execute(final Object[] args) {
    return SyleniumPartialLinkText.syLinkText((String) args[0]);
  }
}
