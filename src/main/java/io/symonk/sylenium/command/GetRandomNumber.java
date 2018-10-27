package io.symonk.sylenium.command;


import com.github.javafaker.Faker;
import io.symonk.sylenium.interfaces.SyleniumCommand;

public class GetRandomNumber implements SyleniumCommand<Long> {

    private final Faker faker = new Faker();

    @Override
    public Long execute() {
        return faker.number().randomNumber();
    }
}
