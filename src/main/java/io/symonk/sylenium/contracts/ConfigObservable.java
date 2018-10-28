package io.symonk.sylenium.contracts;

public interface ConfigObservable {

  void registerObserver(final ConfigObserver observer);

  void removeObserver(final ConfigObserver observer);

  int getObserverCount();

}
