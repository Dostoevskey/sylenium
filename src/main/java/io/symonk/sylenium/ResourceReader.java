package io.symonk.sylenium;

import io.symonk.sylenium.impl.LocalisationFileReader;
import io.symonk.sylenium.impl.PropertyManager;
import org.slf4j.Logger;

public class ResourceReader {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ResourceReader.class);
    private final LocalisationFileReader localisationFileReader = new LocalisationFileReader();

  public ResourceReader(final PropertyManager cfgManager) {
    cfgManager.registerObserver(localisationFileReader);
  }

  public String localisedValueOf(final String key) {
    return localisationFileReader.getLanguageValue(key);
  }
}
