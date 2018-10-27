package io.symonk.sylenium.command;


import com.github.javafaker.Faker;
import io.symonk.sylenium.interfaces.SyleniumCommand;

public class GetRandomNumberBetween implements SyleniumCommand<Integer> {

    private final Faker faker = new Faker();
    private final int min, max;

    public GetRandomNumberBetween(final int min, final int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Integer execute() {
        return faker.number().numberBetween(min, max);
    }
}
