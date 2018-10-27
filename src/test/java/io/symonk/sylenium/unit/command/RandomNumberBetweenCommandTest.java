package io.symonk.sylenium.unit.command;


import io.symonk.sylenium.command.GetRandomNumberBetween;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberBetweenCommandTest {

    private final int min = 1;
    private final int max = 1000;
    private final GetRandomNumberBetween command = new GetRandomNumberBetween(min, max);

    @Test(invocationCount = 1000)
    public void randomNumberIsBetweenCorrect() {
        assertThat(command.execute()).isBetween(min, max);
    }


}
