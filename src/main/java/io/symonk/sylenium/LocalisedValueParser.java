package io.symonk.sylenium;

public class LocalisedValueParser {

  private final LocalisationFileReader localisationFileReader = new LocalisationFileReader();

  public LocalisedValueParser(final ConfigManager cfgManager) {
    cfgManager.registerObserver(localisationFileReader);
  }

  public String localisedValueOf(final String key) {
    return localisationFileReader.getLanguageValue(key);
  }


}
