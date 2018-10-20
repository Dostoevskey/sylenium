package io.symonk.sylenium;

public class Sylenium {

  private final ConfigManager cfgManager = new ConfigManager();
  private final LocalisedValueParser valueParser = new LocalisedValueParser(cfgManager);

  public String localisedValueOf(final String key) {
    return valueParser.localisedValueOf(key);
  }

  public void setProperty(final String key, final String value) {
    cfgManager.setProperty(key, value);
  }


}
