package io.symonk.sylenium.command.browser;

import io.symonk.sylenium.ResourceReader;
import io.symonk.sylenium.SyleniumLinkText;
import io.symonk.sylenium.contracts.SyleniumCommand;
import org.openqa.selenium.By;

public class ExactLocalisedLinkTextLookupCommand implements SyleniumCommand<By> {


  @Override
  public By execute(final Object[] args) {
    ResourceReader reader = (ResourceReader) args[0];
    return SyleniumLinkText.syLinkText(reader.localisedValueOf((String) args[1]));
  }
}
