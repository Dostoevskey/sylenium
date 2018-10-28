package io.symonk.sylenium.contracts;

public interface SyleniumCommand<T> {

    T execute(final Object[] args);
}
