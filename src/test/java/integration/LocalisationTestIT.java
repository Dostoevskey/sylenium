package integration;


import io.symonk.sylenium.Sylenium;
import io.symonk.sylenium.ex.NoSuchLanguageFileException;
import io.symonk.sylenium.ex.NoSuchLocalisedPropertyException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class LocalisationTestIT {

    private Sylenium sy = new Sylenium();

    @BeforeTest
    public void clearProperties() {
    }

    @Test(expectedExceptions = NoSuchLanguageFileException.class)
    public void noLocalisationFileThrowsNoSuchLanguageFileException() {
        sy.updateLocalisationFile("made-up.properties");
        sy.localisedValueOf("fail");
    }

    @Test
    public void validLocalisationFileCanReadProperty() {
        sy.updateLocalisationFile("english.properties");
        Assert.assertEquals(sy.localisedValueOf("one"), "1");
    }

    @Test
    public void runtimeChangesToLanguageFileAreAccurate() {
        sy.updateLocalisationFile("english.properties");
        Assert.assertEquals(sy.localisedValueOf("one"), "1");
        sy.updateLocalisationFile("jibberish.properties");
        Assert.assertEquals(sy.localisedValueOf("tango"), "orange");
    }

    @Test(expectedExceptions = NoSuchLocalisedPropertyException.class)
    public void noSuchPropertyThrowsNoSuchLocalisedPropertyException() {
        sy.updateLocalisationFile("english.properties");
        Assert.assertEquals(sy.localisedValueOf("n0p3"), "1");
    }

    @Test
    public void updatingLanguageViaSetterWorks() {
        sy.updateLocalisationFile("jibberish.properties");
        Assert.assertEquals(sy.localisedValueOf("tango"), "orange");
    }

}
