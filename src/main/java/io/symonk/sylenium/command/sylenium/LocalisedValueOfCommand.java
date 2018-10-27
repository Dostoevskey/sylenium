package io.symonk.sylenium.command.sylenium;

import io.symonk.sylenium.ResourceReader;
import io.symonk.sylenium.interfaces.SyleniumCommand;


public class LocalisedValueOfCommand implements SyleniumCommand<String> {

    @Override
    public String execute(final Object[] args) {
        return ((ResourceReader) args[0]).localisedValueOf((String) args[1]);
    }

}
