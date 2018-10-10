package io.symonk.github.integration.Syunix.commands;

import io.symonk.github.integration.Syunix.Command;
import io.symonk.github.integration.Syunix.SyUnix;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.io.IOException;

@Slf4j
public class Ls implements Command<String[]> {

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
