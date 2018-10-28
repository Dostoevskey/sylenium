package io.symonk.sylenium.command.sylenium;


import io.symonk.sylenium.contracts.SyleniumCommand;
import io.symonk.sylenium.impl.PropertyManager;

public class GetPropertyCommand implements SyleniumCommand<String> {

    @Override
    public String execute(final Object[] args) {
        return ((PropertyManager) args[0]).getProperty((String) args[1]);
    }
}
