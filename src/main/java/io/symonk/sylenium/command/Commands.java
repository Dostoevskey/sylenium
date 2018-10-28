package io.symonk.sylenium.command;


import io.symonk.sylenium.command.browser.ExactLocalisedLinkTextLookupCommand;
import io.symonk.sylenium.command.browser.PartialLocalisedLinkTextLookupCommand;
import io.symonk.sylenium.command.browser.StartCommand;
import io.symonk.sylenium.command.data.GetRandomFirstNameCommand;
import io.symonk.sylenium.command.data.GetRandomLastNameCommand;
import io.symonk.sylenium.command.data.GetRandomNumberBetweenCommand;
import io.symonk.sylenium.command.data.GetRandomNumberCommand;
import io.symonk.sylenium.command.sylenium.*;
import io.symonk.sylenium.interfaces.SyleniumCommand;
import org.openqa.selenium.InvalidArgumentException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Commands {
    INSTANCE;

    Commands() {
        reset();
    }

    private final Map<String, SyleniumCommand> mapOfCommands = new HashMap<>(32);

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
        register("randomNumber", new GetRandomNumberCommand());
        register("randomNumberBetween", new GetRandomNumberBetweenCommand());
    }

    private void registerBrowserCommands() {
        register("start", new StartCommand());
        register("exactLinkText", new ExactLocalisedLinkTextLookupCommand());
        register("partialLinkText", new PartialLocalisedLinkTextLookupCommand());
    }

    private void registerSyleniumCommands() {
        register("localisedValueOf", new LocalisedValueOfCommand());
        register("registerWorldObject", new RegisterWorldObjectCommand());
        register("unregisterWorldObject", new UnregisterWorldObjectCommand());
        register("cleanUpWorld", new CleanUpWorldCommand());
        register("getProperty", new GetPropertyCommand());
        register("getWorldSize", new GetWorldSizeCommand());
        register("updateProperty", new UpdatePropertyCommand());
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
