package io.symonk.sylenium.command.sylenium;


import io.symonk.sylenium.interfaces.ConfigObservable;
import io.symonk.sylenium.interfaces.SyleniumCommand;

public class GetConfigObserverCountCommand implements SyleniumCommand<Integer> {

    @Override
    public Integer execute(final Object[] args) {
        return ((ConfigObservable) args[0]).getObserverCount();
    }
}
