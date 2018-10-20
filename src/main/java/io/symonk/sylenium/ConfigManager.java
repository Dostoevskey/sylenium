package io.symonk.sylenium;


import org.aeonbits.owner.ConfigFactory;

import java.util.ArrayList;
import java.util.List;

public class ConfigManager implements ConfigObservable {

    private final SyleniumConfig config = ConfigFactory.create(SyleniumConfig.class);
    private final List<ConfigObserver> myObservers = new ArrayList<>();

    @Override
    public void registerObserver(final ConfigObserver observer) {
        myObservers.add(observer);
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

    public String getProperty(final String key) {
        return config.getProperty(key);
    }

}
