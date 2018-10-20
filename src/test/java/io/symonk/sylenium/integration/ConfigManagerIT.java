package io.symonk.sylenium.integration;


import io.symonk.sylenium.ConfigManager;
import io.symonk.sylenium.LocalisationFileReader;
import io.symonk.sylenium.TestBase;
import io.symonk.sylenium.ex.NoSuchLanguageFileException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigManagerIT extends TestBase {

    private ConfigManager configManager = new ConfigManager();

    @Test
    public void canGetAndSetProperty() {
        configManager.setProperty("$ylenium.language.file", "ok.properties");
        Assert.assertEquals(configManager.getProperty("$ylenium.language.file"), "ok.properties");
    }

//    @Test(expectedExceptions = NoSuchLanguageFileException.class)
//    public void registeredObserversAreNotified() {
//        final LocalisationFileReader one = new LocalisationFileReader();
//        final LocalisationFileReader two = new LocalisationFileReader();
//        configManager.registerObserver(one);
//        configManager.registerObserver(two);
//        sy.setProperty("$y.language.file", "dumbo.properties");
//        one.getLanguageValue("wont-exist.properties");
//    }
}
