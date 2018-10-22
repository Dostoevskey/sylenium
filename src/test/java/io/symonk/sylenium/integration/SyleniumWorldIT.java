package io.symonk.sylenium.integration;

import io.symonk.sylenium.Sylenium;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SyleniumWorldIT {

    private Sylenium sy;

    @BeforeTest
    public void setup() {
        sy = new Sylenium();
    }

    @Test
    public void registerWorldObject() {
        sy.register(new DummyWorldObject());
        Assert.assertEquals(sy.getWorldSize(), 1);
    }

    @Test
    public void canCleanUpTheWorld() {
        sy.register(new DummyWorldObject());
        sy.cleanUpWorld();
        Assert.assertEquals(sy.getWorldSize(), 0);
    }
}
