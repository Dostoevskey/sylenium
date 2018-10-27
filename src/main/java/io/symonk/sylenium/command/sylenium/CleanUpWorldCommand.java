package io.symonk.sylenium.command.sylenium;

import io.symonk.sylenium.SyleniumWorld;
import io.symonk.sylenium.interfaces.SyleniumCommand;

public class CleanUpWorldCommand implements SyleniumCommand<Void> {

  @Override
  public Void execute(final Object[] args) {
    ((SyleniumWorld) args[0]).cleanUpWorld();
    return null;
  }
}
