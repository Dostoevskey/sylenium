package io.symonk.sylenium.command.fakedata;

import com.github.javafaker.Faker;
import io.symonk.sylenium.interfaces.SyleniumCommand;

public class GetRandomFirstNameCommand implements SyleniumCommand<String> {

  private Faker faker = new Faker();

  @Override
  public String execute(final Object[] args) {
    return faker.name().firstName();
  }
}
