package io.symonk.sylenium;

import org.aeonbits.owner.ConfigFactory;

public class Sylenium {

  private final SyleniumConfig config = ConfigFactory.create(SyleniumConfig.class);
  private final LocalisedValueParser valueParser = new LocalisedValueParser(config.localisationFile());

  public String localisedValueOf(final String key) {
    return valueParser.localised(key);
  }

  public Sylenium updateLocalisationFile(final String newLocalisationFile) {
    config.setProperty("$y.localisation.file", newLocalisationFile);
    valueParser.setLocalisationFile(newLocalisationFile);
    return this;
  }


}
