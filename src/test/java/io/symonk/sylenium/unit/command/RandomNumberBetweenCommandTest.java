package io.symonk.sylenium.unit.command;


import io.symonk.sylenium.command.data.GetRandomNumberBetweenCommand;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberBetweenCommandTest {

    private final int min = 1;
    private final int max = 1000;

    @Test
    public void randomNumberIsBetweenCorrect() {
        assertThat(new GetRandomNumberBetweenCommand().execute(new Object[]{})).isBetween(min, max);
    }


}
