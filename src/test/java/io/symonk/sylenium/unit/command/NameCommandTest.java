package io.symonk.sylenium.unit.command;


import io.symonk.sylenium.command.fakedata.GetRandomFullNameCommand;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameCommandTest {

    private final GetRandomFullNameCommand command = new GetRandomFullNameCommand();

    @Test
    public void canRetrieveRandomFullName() {
    assertThat(command.execute(new Object[]{})).isNotEmpty();
    }


}
