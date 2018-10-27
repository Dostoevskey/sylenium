package io.symonk.sylenium.unit.command;


import io.symonk.sylenium.command.data.GetRandomNumberBetweenCommand;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberBetweenCommandTest {

    private final int min = 1;
    private final int max = 1000;
    private final GetRandomNumberBetweenCommand command = new GetRandomNumberBetweenCommand(min, max);

    @Test(invocationCount = 3)
    public void randomNumberIsBetweenCorrect() {
        assertThat(command.execute(new Object[]{})).isBetween(min, max);
    }


}
