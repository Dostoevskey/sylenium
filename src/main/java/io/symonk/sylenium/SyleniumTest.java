package io.symonk.sylenium;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SyleniumTest {

    protected final Sylenium sylenium = new Sylenium();

    @BeforeTest
    public void beforeTest() {

    }


    @AfterTest
    public void cleaningUp() {
        sylenium.cleanUpWorld();
    }



}
