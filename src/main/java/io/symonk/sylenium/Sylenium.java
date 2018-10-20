package io.symonk.sylenium;

import io.symonk.sylenium.ex.NoSuchLocalisedPropertyException;

import java.util.Optional;

public class Sylenium {

  private final ConfigManager cfgManager = new ConfigManager();
  private final LocalisedValueParser valueParser = new LocalisedValueParser(cfgManager);
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


}
