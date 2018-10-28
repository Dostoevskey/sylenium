package io.symonk.sylenium.interfaces;

public interface ConfigObservable {

  void registerObserver(final ConfigObserver observer);

  void removeObserver(final ConfigObserver observer);

  int getObserverCount();

}
