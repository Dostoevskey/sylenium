package io.symonk.sylenium.command;

import com.github.javafaker.Faker;
import io.symonk.sylenium.interfaces.SyleniumCommand;


public class GetRandomFullName implements SyleniumCommand<String> {

    private Faker faker = new Faker();

    @Override
    public String execute() {
        return faker.name().fullName();
    }
}
