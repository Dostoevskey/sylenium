package io.symonk.sylenium.command.data;

import com.github.javafaker.Faker;
import io.symonk.sylenium.contracts.SyleniumCommand;

public class GetRandomFirstNameCommand implements SyleniumCommand<String> {

  private Faker faker = new Faker();

  @Override
  public String execute(final Object[] args) {
    return faker.name().firstName();
  }
}
