package io.symonk.sylenium;

import io.symonk.sylenium.impl.PropertyManager;
import io.symonk.sylenium.impl.LocalisationFileReader;

public class ResourceReader {

  private final LocalisationFileReader localisationFileReader = new LocalisationFileReader();

  public ResourceReader(final PropertyManager cfgManager) {
    cfgManager.registerObserver(localisationFileReader);
  }

  public String localisedValueOf(final String key) {
    return localisationFileReader.getLanguageValue(key);
  }
}
