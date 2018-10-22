package io.symonk.sylenium;


import io.symonk.sylenium.interfaces.SyleniumObject;
import org.testng.annotations.AfterTest;

public class SyleniumTest {

    private final ThreadLocal<Sylenium> sylenium = new ThreadLocal<>();

    protected <T extends SyleniumObject> void registerTestData(T t) {
        sylenium.get().register(t);
    }

    protected String localisedOf(final String key) {
        return sylenium.get().localisedValueOf(key);
    }


    @AfterTest
    public void cleaningUp() {
        sylenium.get().cleanUpWorld();
    }



}
