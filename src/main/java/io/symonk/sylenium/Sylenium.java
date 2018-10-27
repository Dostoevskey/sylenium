package io.symonk.sylenium;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.symonk.sylenium.impl.ConfigManager;
import io.symonk.sylenium.interfaces.ConfigObserver;
import io.symonk.sylenium.interfaces.SyleniumObject;

import static com.codeborne.selenide.Selenide.$;

public class Sylenium {

  private final ConfigManager cfgManager = new ConfigManager();
  private final ThreadLocal<ResourceReader> valueParser = ThreadLocal.withInitial(() -> new ResourceReader(cfgManager));
  private final ThreadLocal<SyleniumWorld> world = ThreadLocal.withInitial(SyleniumWorld::new);

  public synchronized int getCfgObserversCount() {
    return cfgManager.getObserverCount();
  }

  public synchronized <T extends ConfigObserver> void unregisterConfigObserver(T object) {
    cfgManager.removeObserver(object);
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
    return cfgManager.getProperty(key);
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

  public <T> T launch(final String url, final Class<T> pageObject) {
    return Selenide.open(url, pageObject);
  }

  public SelenideElement localisedLinkText(final String resourceKey) {
    return $(SyleniumLinkText.$yLinkText(localisedValueOf(resourceKey)));
  }

}
