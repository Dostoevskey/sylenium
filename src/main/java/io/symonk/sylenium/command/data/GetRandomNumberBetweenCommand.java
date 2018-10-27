package io.symonk.sylenium.command.data;


import com.github.javafaker.Faker;
import io.symonk.sylenium.interfaces.SyleniumCommand;

public class GetRandomNumberBetweenCommand implements SyleniumCommand<Integer> {

    private final Faker faker = new Faker();
    private final int min;
    private final int max;

    public GetRandomNumberBetweenCommand(final int min, final int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Integer execute(final Object[] args) {
        return faker.number().numberBetween(min, max);
    }
}
