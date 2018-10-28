package io.symonk.sylenium.command.sylenium;


import io.symonk.sylenium.SyleniumWorld;
import io.symonk.sylenium.contracts.SyleniumCommand;
import io.symonk.sylenium.contracts.SyleniumObject;

@SuppressWarnings("unchecked")
public class UnregisterWorldObjectCommand implements SyleniumCommand<Void> {

    @Override
    public Void execute(final Object[] args) {
        ((SyleniumWorld) args[0]).unregisterObject((SyleniumObject) args[1]);
        return null;
    }
}
