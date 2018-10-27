package io.symonk.sylenium.command;


import io.symonk.sylenium.command.browser.StartCommand;
import io.symonk.sylenium.command.data.GetRandomFirstNameCommand;
import io.symonk.sylenium.command.data.GetRandomLastNameCommand;
import io.symonk.sylenium.command.sylenium.CleanUpWorldCommand;
import io.symonk.sylenium.command.sylenium.LocalisedValueOfCommand;
import io.symonk.sylenium.command.sylenium.RegisterWorldObjectCommand;
import io.symonk.sylenium.command.sylenium.UnregisterWorldObjectCommand;
import io.symonk.sylenium.interfaces.SyleniumCommand;
import org.openqa.selenium.InvalidArgumentException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Commands {
    INSTANCE;

    private final Map<String, SyleniumCommand> mapOfCommands = new HashMap<>(128);

    private void reset() {
        mapOfCommands.clear();
        registerDataCommands();
        registerBrowserCommands();
        registerSyleniumCommands();
    }

    private void registerDataCommands() {
        register("getName", new GetRandomFirstNameCommand());
        register("getLastName", new GetRandomLastNameCommand());
        register("getFirstName", new GetRandomFirstNameCommand());
    }

    private void registerBrowserCommands() {
        register("start", new StartCommand());
    }

    private void registerSyleniumCommands() {
        register("localisedValueOf", new LocalisedValueOfCommand());
        register("registerWorldObject", new RegisterWorldObjectCommand());
        register("unregisterWorldObject", new UnregisterWorldObjectCommand());
        register("cleanUpWorld", new CleanUpWorldCommand());
    }

    private void register(final String name, final SyleniumCommand command) {
        mapOfCommands.put(name, command);
    }

    @SuppressWarnings("unchecked")
    public <T> T execute(final String methodName, final Object[] args) {
        SyleniumCommand command = Optional.ofNullable(mapOfCommands.get(methodName)).orElseThrow(() -> new InvalidArgumentException("No Such Sylenium Command: " + methodName));
        return (T) command.execute(args);
    }




}
