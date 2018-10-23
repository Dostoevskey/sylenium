package io.symonk.sylenium;

import com.codeborne.selenide.Selenide;
import io.symonk.sylenium.ex.NoSuchLocalisedPropertyException;
import io.symonk.sylenium.impl.ConfigManager;
import io.symonk.sylenium.interfaces.ConfigObserver;
import io.symonk.sylenium.interfaces.SyleniumObject;

import java.util.Optional;

public class Sylenium {

  private final ConfigManager cfgManager = new ConfigManager();
  private final ThreadLocal<ResourceReader> valueParser = ThreadLocal.withInitial(() -> new ResourceReader(cfgManager));
  private final ThreadLocal<SyleniumWorld> world = ThreadLocal.withInitial(SyleniumWorld::new);

  public synchronized int getCfgObserversCount() {
    return cfgManager.getObserverCount();
  }

  public synchronized <T extends ConfigObserver> void registerConfigObserver(T object) {
    cfgManager.registerObserver(object);
  }

  public String localisedValueOf(final String key) {
    return valueParser.get().localisedValueOf(key);
  }

  public synchronized void setProperty(final String key, final String value) {
    cfgManager.setProperty(key, value);
  }

  public synchronized String getProperty(final String key) {
    return Optional.ofNullable(cfgManager.getProperty(key))
        .orElseThrow(
            () -> new NoSuchLocalisedPropertyException("property: " + key + " does not exist"));
  }

  public synchronized void removeProperty(final String key) {
    cfgManager.removeProperty(key);
  }

  public <T extends SyleniumObject> void register(final T object) {
    world.get().registerObject(object);
  }

  public void cleanUpWorld() {
    world.get().cleanUpWorld();
  }

  public int getWorldSize() {
    return world.get().getWorldSize();
  }

  public <PageObjectClass> PageObjectClass start(final String url, final  Class<PageObjectClass> pageObjectClassClass) {
    return Selenide.open(url, pageObjectClassClass);
  }




}
