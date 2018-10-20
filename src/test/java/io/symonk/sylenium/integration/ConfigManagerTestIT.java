package io.symonk.sylenium.integration;


import io.symonk.sylenium.ConfigManager;
import io.symonk.sylenium.LocalisationFileReader;
import io.symonk.sylenium.TestBase;
import io.symonk.sylenium.ex.NoSuchLanguageFileException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigManagerTestIT extends TestBase {

    private ConfigManager configManager = new ConfigManager();

    @Test
    public void canGetAndSetProperty() {
        configManager.setProperty("$y.localisation.file", "ok.properties");
        Assert.assertEquals(configManager.getProperty("$y.localisation.file"), "ok.properties");
    }

    @Test(expectedExceptions = NoSuchLanguageFileException.class)
    public void configIsUpdatedForRegisteredObservers() {
        final LocalisationFileReader one = new LocalisationFileReader();
        final LocalisationFileReader two = new LocalisationFileReader();
        configManager.registerObserver(one);
        configManager.registerObserver(two);
        sy.setProperty("$y.localisation.file", "dumbo.properties");
        one.getLanguageValue("wont-exist.properties");
    }
}
