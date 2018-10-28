package io.symonk.sylenium.command.sylenium;

import io.symonk.sylenium.SyleniumWorld;
import io.symonk.sylenium.contracts.SyleniumCommand;

public class GetWorldCountCommand implements SyleniumCommand<Integer> {

    @Override
    public Integer execute(final Object[] args) {
        return ((SyleniumWorld) args[0]).getWorldSize();
    }
}
