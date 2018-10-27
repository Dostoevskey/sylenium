package io.symonk.sylenium.unit.command;


import io.symonk.sylenium.command.GetRandomNumber;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberCommandTest {

    private final GetRandomNumber command = new GetRandomNumber();

    @Test
    public void randomNumberIsGreaterThanZero() {
        assertThat(command.execute()).isGreaterThan(0);
    }
}
