package io.symonk.sylenium.command.sylenium;

import io.symonk.sylenium.contracts.ConfigObservable;
import io.symonk.sylenium.contracts.ConfigObserver;
import io.symonk.sylenium.contracts.SyleniumCommand;


public class ObserveConfigCommand implements SyleniumCommand<Void> {

    @Override
    public Void execute(final Object[] args) {
        ((ConfigObservable) args[0]).registerObserver((ConfigObserver) args[1]);
        return null;
    }
}
