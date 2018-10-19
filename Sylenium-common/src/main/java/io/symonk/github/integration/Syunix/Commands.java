package io.symonk.github.integration.Syunix;

import io.symonk.github.integration.Syunix.commands.Ls;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Commands {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Commands.class);
    private static Commands collection;

    private final Map<String, Command> commands = new ConcurrentHashMap<>(10);

    public static synchronized Commands getInstance() {
        if(collection == null) {
            collection = new Commands();
            collection.reset();
        }
        return collection;
    }

    public final synchronized void reset() {
        commands.clear();
        addTechnicalCommands();

    }

    private void addTechnicalCommands() {
        add("ls", new Ls());
    }

    public void add(final String method, Command command) {
        commands.put(method, command);
    }

    public <T> T execute(final SyUnix syUnix, final String commandName, final Object[] args) throws IOException {
        final Command command = commands.get(commandName);
        if(command == null) throw new IllegalStateException("Unsupported command attempted." + commandName);
        return (T) command.execute(syUnix, args);
    }





}
