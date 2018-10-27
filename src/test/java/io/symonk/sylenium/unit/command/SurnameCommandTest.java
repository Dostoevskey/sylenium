package io.symonk.sylenium.unit.command;


import io.symonk.sylenium.command.GetRandomLastName;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SurnameCommandTest {

    private final GetRandomLastName command = new GetRandomLastName();

    @Test
    public void canRetrieveRandomFullName() {
        assertThat(command.execute()).isNotEmpty();
    }

}
