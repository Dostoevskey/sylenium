package io.symonk.sylenium.integration.testrail.model;


import java.util.function.Consumer;

public class TestrailRunBuilder {

    public int suite_id;
    public String name;
    public String description;
    public boolean include_all;
    public int[] case_ids;

    public TestrailRunBuilder with(Consumer<TestrailRunBuilder> builderFunction) {
        builderFunction.accept(this);
        return this;
    }

    public TestrailRun create() {
        return new TestrailRun(suite_id, name, description, include_all, case_ids);
    }

}
