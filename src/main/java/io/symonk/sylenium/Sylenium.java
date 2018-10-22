package io.symonk.sylenium;

import io.symonk.sylenium.ex.NoSuchLocalisedPropertyException;
import io.symonk.sylenium.impl.ConfigManager;
import io.symonk.sylenium.interfaces.SyleniumObject;

import java.util.Optional;

public class Sylenium {

  private final ConfigManager cfgManager = new ConfigManager();
  private final ResourceReader valueParser = new ResourceReader(cfgManager);
  private final SyleniumWorld world = new SyleniumWorld();


  public String localisedValueOf(final String key) {
    return valueParser.localisedValueOf(key);
  }

  public void setProperty(final String key, final String value) {
    cfgManager.setProperty(key, value);
  }

  public String getProperty(final String key) {
    return Optional.ofNullable(cfgManager.getProperty(key)).orElseThrow(() -> new NoSuchLocalisedPropertyException("property: " + key + " does not exist"));
  }

  public <T extends SyleniumObject> void register(final T object) {
    world.registerObject(object);
  }

  public void cleanUpWorld() {
    world.cleanUpWorld();
  }

  public int getWorldSize() {
    return world.getWorldSize();
  }


}
