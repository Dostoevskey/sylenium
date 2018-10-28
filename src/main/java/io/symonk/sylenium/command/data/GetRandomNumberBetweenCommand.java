package io.symonk.sylenium.command.data;


import com.github.javafaker.Faker;
import io.symonk.sylenium.interfaces.SyleniumCommand;

public class GetRandomNumberBetweenCommand implements SyleniumCommand<Integer> {

    private final Faker faker = new Faker();

    @Override
    public Integer execute(final Object[] args) {
        return faker.number().numberBetween((Integer) args[0], (Integer) args[1]);
    }
}
