package io.symonk.sylenium;

import org.testng.annotations.BeforeTest;

public class TestBase {

    protected Sylenium sy;

    @BeforeTest
    public void beforeAll() {
        sy = new Sylenium();
    }


    protected void setLocalisationFile(final String value) {
        sy.setProperty("$y.localisation.file", value);
    }
}
