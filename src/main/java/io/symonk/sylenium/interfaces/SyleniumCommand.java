package io.symonk.sylenium.interfaces;

public interface SyleniumCommand<T> {

    T execute(final Object[] args);
}
