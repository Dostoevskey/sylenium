package io.symonk.sylenium.command.data;

import com.github.javafaker.Faker;
import io.symonk.sylenium.interfaces.SyleniumCommand;


public class GetRandomFullNameCommand implements SyleniumCommand<String> {

    private Faker faker = new Faker();

    @Override
    public String execute(final Object[] args) {
        return faker.name().fullName();
    }
}
