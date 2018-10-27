package io.symonk.sylenium.command.sylenium;


import io.symonk.sylenium.SyleniumWorld;
import io.symonk.sylenium.interfaces.SyleniumCommand;
import io.symonk.sylenium.interfaces.SyleniumObject;

@SuppressWarnings("unchecked")
public class RegisterWorldObjectCommand implements SyleniumCommand<Void> {

    @Override
    public Void execute(final Object[] args) {
        ((SyleniumWorld) args[0]).registerObject((SyleniumObject) args[1]);
        return null;
    }
}
