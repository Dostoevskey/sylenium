package io.symonk.sylenium.command;


import io.symonk.sylenium.interfaces.SyleniumCommand;
import org.openqa.selenium.InvalidArgumentException;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class Commands {
    public static Commands comms;

    private final Map<String, SyleniumCommand> commands = new ConcurrentHashMap<>(128);

    public static synchronized Commands getInstance() {
        if (comms == null) {
            comms = new Commands();
            comms.reset();
        }
        return comms;
    }

    private void reset() {
        commands.clear();
        registerDataCommands();
    }

    private void registerDataCommands() {
        register("random.first.name", new GetRandomFirstName());
        register("random.last.name", new GetRandomLastName());
    }

    private void register(final String name, final SyleniumCommand command) {
        commands.put(name, command);
    }

    @SuppressWarnings("unchecked")
    public <T> T execute(final String methodName) {
        SyleniumCommand command = Optional.ofNullable(commands.get(methodName)).orElseThrow(() -> new InvalidArgumentException("No Such Sylenium Command: " + methodName));
        return (T) command.execute();
    }




}
