package io.symonk.sylenium.command.browser;

import io.symonk.sylenium.SyleniumLinkText;
import io.symonk.sylenium.interfaces.SyleniumCommand;
import org.openqa.selenium.By;

public class ExactLocalisedLinkTextLookupCommand implements SyleniumCommand<By> {


  @Override
  public By execute(final Object[] args) {
    return SyleniumLinkText.syLinkText((String) args[0]);
  }
}
