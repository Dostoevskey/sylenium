package io.symonk.sylenium.contracts;

import org.aeonbits.owner.Accessible;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.HotReload;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Mutable;

@HotReload
@Sources("classpath:sy.properties")
public interface SyleniumConfig extends Config, Mutable, Accessible {

  @Key("sy.enable.localisation")
  @DefaultValue("false")
  boolean isLocalisationEnabled();

  @Key("sy.localisation.file")
  @DefaultValue("english.properties")
  String localisationFile();
}
