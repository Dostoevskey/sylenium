package io.symonk.sylenium.impl;


import io.symonk.sylenium.interfaces.ConfigObservable;
import io.symonk.sylenium.interfaces.ConfigObserver;
import io.symonk.sylenium.interfaces.SyleniumConfig;
import org.aeonbits.owner.ConfigFactory;

import java.util.ArrayList;
import java.util.List;

public class ConfigManager implements ConfigObservable {

    private final SyleniumConfig config = ConfigFactory.create(SyleniumConfig.class);
    private final List<ConfigObserver> myObservers = new ArrayList<>();

    @Override
    public void registerObserver(final ConfigObserver observer) {
        myObservers.add(observer);
        notify(config);
    }

    @Override
    public void removeObserver(final ConfigObserver observer) {
        myObservers.remove(observer);
    }

    @Override
    public void notify(final SyleniumConfig config) {
        myObservers.forEach(observer -> observer.update(config));
    }

    public void setProperty(final String key, final String value) {
        config.setProperty(key, value);
        notify(config);
    }

    public void removeProperty(final String key) {
        config.removeProperty(key);
        notify(config);
    }

    public String getProperty(final String key) {
        return config.getProperty(key) == null ? "" : config.getProperty(key);
    }

    public int getObserverCount() {
        return myObservers.size();
    }

}
