package io.symonk.github.Syunix;


import java.io.IOException;

public interface Command<T> {

    T execute(final SyUnix syUnix) throws IOException;

}
