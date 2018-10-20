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
        setLocalisationFile("made-up.properties");
        sy.localisedValueOf("fail");
    }

    @Test
    public void validLocalisationFileCanReadProperty() {
        setLocalisationFile("english.properties");
        Assert.assertEquals(sy.localisedValueOf("one"), "1");
    }

    @Test
    public void runtimeChangesToLanguageFileAreAccurate() {
        setLocalisationFile("english.properties");
        Assert.assertEquals(sy.localisedValueOf("one"), "1");
        setLocalisationFile("jibberish.properties");
        Assert.assertEquals(sy.localisedValueOf("tango"), "orange");
    }

    @Test(expectedExceptions = NoSuchLocalisedPropertyException.class)
    public void noSuchPropertyThrowsNoSuchLocalisedPropertyException() {
        setLocalisationFile("english.properties");
        Assert.assertEquals(sy.localisedValueOf("n0p3"), "1");
    }

    @Test
    public void updatingLanguageViaSetterWorks() {
        setLocalisationFile("jibberish.properties");
        Assert.assertEquals(sy.localisedValueOf("tango"), "orange");
    }

    private void setLocalisationFile(final String value) {
        sy.setProperty("$y.localisation.file", value);
    }

}
