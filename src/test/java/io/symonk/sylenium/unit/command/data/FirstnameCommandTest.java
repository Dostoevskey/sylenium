package io.symonk.sylenium.unit.command.data;

import io.symonk.sylenium.command.data.GetRandomFirstNameCommand;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstnameCommandTest {

  private final GetRandomFirstNameCommand command = new GetRandomFirstNameCommand();

  @Test
  public void canRetrieveRandomFullName() {
    assertThat(command.execute(new Object[]{})).isNotEmpty();
  }
}
