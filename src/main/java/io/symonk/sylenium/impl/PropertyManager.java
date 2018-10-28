package io.symonk.sylenium.impl;

import io.symonk.sylenium.contracts.ConfigObservable;
import io.symonk.sylenium.contracts.ConfigObserver;
import io.symonk.sylenium.contracts.SyleniumConfig;
import org.aeonbits.owner.ConfigFactory;

import java.util.ArrayList;
import java.util.List;

public class PropertyManager implements ConfigObservable {

  private final SyleniumConfig config = ConfigFactory.create(SyleniumConfig.class);
  private final List<ConfigObserver> myObservers = new ArrayList<>();


  @Override
  public void registerObserver(final ConfigObserver observer) {
    myObservers.add(observer);
    notify(config);
  }

  @Override
  public void removeObserver(final ConfigObserver observer) {
    myObservers.removeIf(obj -> obj.equals(observer));
  }

  @Override
  public int getObserverCount() {
    return myObservers.size();
  }


  private void notify(final SyleniumConfig config) {
    myObservers.forEach(observer -> observer.update(config));
  }

  public void updateProperty(final String key, final String value) {
    config.setProperty(key, value);
    notify(config);
  }

  public String getProperty(final String key) {
    return config.getProperty(key) == null ? "" : config.getProperty(key);
  }

}
