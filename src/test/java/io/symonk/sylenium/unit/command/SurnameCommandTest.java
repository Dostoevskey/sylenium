package io.symonk.sylenium.unit.command;


import io.symonk.sylenium.command.fakedata.GetRandomLastNameCommand;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SurnameCommandTest {

    private final GetRandomLastNameCommand command = new GetRandomLastNameCommand();

    @Test
    public void canRetrieveRandomFullName() {
        assertThat(command.execute(new Object[]{})).isNotEmpty();
    }

}
