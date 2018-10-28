package io.symonk.sylenium.command.sylenium;


import io.symonk.sylenium.impl.PropertyManager;
import io.symonk.sylenium.interfaces.SyleniumCommand;

public class UpdatePropertyCommand implements SyleniumCommand<Void> {

    @Override
    public Void execute(final Object[] args) {
        ((PropertyManager) args[0]).updateProperty((String) args[1], (String) args[2]);
        return null;
    }
}
