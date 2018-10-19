package io.symonk.sylenium;

import org.aeonbits.owner.Accessible;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.HotReload;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Mutable;

@HotReload
@Sources("classpath:sylenium.properties")
public interface SyleniumConfig extends Config, Mutable, Accessible {

    /** $ylenium localisation */

    @Key("$y.enable.localisation")
    @DefaultValue("false")
    boolean isLocalisationEnabled();

    @Key("$y.localisation.file")
    @DefaultValue("english.properties")
    String localisationFile();


}
