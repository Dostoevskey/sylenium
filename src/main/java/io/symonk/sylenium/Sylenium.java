package io.symonk.sylenium;

import org.aeonbits.owner.ConfigFactory;

import java.util.logging.Logger;

public class Sylenium {
  private final Logger log = Logger.getLogger(getClass().getName());

  private final $yConfig config = ConfigFactory.create($yConfig.class);
  private final LocalisedValueParser valueParser = new LocalisedValueParser(config.localisationFile());

  public Sylenium() {

  }

  public String localisedValueOf(final String key) {
    return valueParser.localised(key);
  }

  public Sylenium updateLocalisationFile(final String newLocalisationFile) {
    config.setProperty("$y.localisation.file", newLocalisationFile);
    valueParser.setLocalisationFile(newLocalisationFile);
    return this;
  }


}
