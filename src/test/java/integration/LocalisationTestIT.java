package integration;


import io.symonk.sylenium.Sylenium;
import io.symonk.sylenium.ex.NoSuchLanguageFileException;
import io.symonk.sylenium.ex.NoSuchLocalisedPropertyException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class LocalisationTestIT {

    private Sylenium $y;

    @BeforeTest
    public void clearProperties() {
        System.clearProperty("sylenium.language.file");
        $y = Sylenium.getInstance();
    }

    @Test(expectedExceptions = NoSuchLanguageFileException.class)
    public void noLocalisationFileThrowsNoSuchLanguageFileException() {
        System.setProperty("sylenium.language.file", "made-up.properties");
        $y.localised("fail");
    }

    @Test
    public void validLocalisationFileCanReadProperty() {
        System.setProperty("sylenium.language.file", "english.properties");
        Assert.assertEquals($y.localised("one"), "1");
    }

    @Test
    public void runtimeChangesToLanguageFileAreAccurate() {
        System.setProperty("sylenium.language.file", "english.properties");
        Assert.assertEquals($y.localised("one"), "1");
        System.setProperty("sylenium.language.file", "jibberish.properties");
        Assert.assertEquals($y.localised("tango"), "orange");
    }

    @Test(expectedExceptions = NoSuchLocalisedPropertyException.class)
    public void noSuchPropertyThrowsNoSuchLocalisedPropertyException() {
        System.setProperty("sylenium.language.file", "english.properties");
        Assert.assertEquals($y.localised("n0p3"), "1");
    }

}
