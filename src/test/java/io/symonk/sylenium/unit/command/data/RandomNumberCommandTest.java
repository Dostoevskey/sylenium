package io.symonk.sylenium.unit.command.data;


import io.symonk.sylenium.command.data.GetRandomNumberCommand;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberCommandTest {

    private final GetRandomNumberCommand command = new GetRandomNumberCommand();

    @Test
    public void randomNumberIsGreaterThanZero() {
        assertThat(command.execute(new Object[]{})).isGreaterThan(0);
    }
}
