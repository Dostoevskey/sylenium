package io.symonk.sylenium;


public interface ConfigObservable {

    void registerObserver(final ConfigObserver observer);

    void removeObserver(final ConfigObserver observer);

    void notify(final SyleniumConfig config);

}
