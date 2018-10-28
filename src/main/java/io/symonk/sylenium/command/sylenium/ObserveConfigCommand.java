package io.symonk.sylenium.command.sylenium;

import io.symonk.sylenium.interfaces.ConfigObservable;
import io.symonk.sylenium.interfaces.ConfigObserver;
import io.symonk.sylenium.interfaces.SyleniumCommand;


public class ObserveConfigCommand implements SyleniumCommand<Void> {

    @Override
    public Void execute(final Object[] args) {
        ((ConfigObservable) args[0]).registerObserver((ConfigObserver) args[1]);
        return null;
    }
}
