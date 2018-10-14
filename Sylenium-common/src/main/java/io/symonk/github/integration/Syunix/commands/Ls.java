package io.symonk.github.integration.Syunix.commands;

import io.symonk.github.integration.Syunix.Command;
import io.symonk.github.integration.Syunix.SyUnix;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.io.IOException;

public class Ls implements Command<String[]> {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Ls.class);
    private final SyUnix syUnix;

    @Inject
    public Ls(final SyUnix syUnix) {
        this.syUnix = syUnix;
    }

    @Override
    public String[] execute(SyUnix syUnix) throws IOException {
        return this.execute(syUnix);
    }
}
