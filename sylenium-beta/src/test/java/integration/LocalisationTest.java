package test.java.integration;


import io.symonk.sylenium.Sylenium;
import io.symonk.sylenium.ex.NoSuchLanguageFileException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class LocalisationTest {

    private final Sylenium $y = Sylenium.getInstance();

    @BeforeTest
    public void clearProperties() {
        System.clearProperty("sylenium.language.file");
    }

    @Test(expectedExceptions = NoSuchLanguageFileException.class)
    public void noLocalisationFileThrowsNoSuchLanguageFileException() {
        System.setProperty("sylenium.language.file", "made-up.properties");
        Sylenium.getInstance();
    }

    @Test
    public void validLocalisationFileCanReadProperty() {
        System.setProperty("sylenium.language.file", "english.properties");
        Assert.assertEquals($y.localised("one"), "1");
    }

}
