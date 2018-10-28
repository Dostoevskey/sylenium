package io.symonk.sylenium.command.sylenium;


import io.symonk.sylenium.contracts.ConfigObservable;
import io.symonk.sylenium.contracts.SyleniumCommand;

public class GetConfigObserverCountCommand implements SyleniumCommand<Integer> {

    @Override
    public Integer execute(final Object[] args) {
        return ((ConfigObservable) args[0]).getObserverCount();
    }
}
