package io.symonk.sylenium.unit.command;


import io.symonk.sylenium.command.GetRandomFullName;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameCommandTest {

    private final GetRandomFullName command = new GetRandomFullName();

    @Test
    public void canRetrieveRandomFullName() {
    assertThat(command.execute()).isNotEmpty();
    }


}
