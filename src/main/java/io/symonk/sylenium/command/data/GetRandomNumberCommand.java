package io.symonk.sylenium.command.data;


import com.github.javafaker.Faker;
import io.symonk.sylenium.interfaces.SyleniumCommand;

public class GetRandomNumberCommand implements SyleniumCommand<Long> {

    private final Faker faker = new Faker();

    @Override
    public Long execute(final Object[] args) {
        return faker.number().randomNumber();
    }
}
