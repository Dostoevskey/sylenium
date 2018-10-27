package io.symonk.sylenium.unit.command;

import io.symonk.sylenium.command.GetRandomFirstName;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstnameCommandTest {

  private final GetRandomFirstName command = new GetRandomFirstName();

  @Test
  public void canRetrieveRandomFullName() {
    assertThat(command.execute()).isNotEmpty();
  }
}
