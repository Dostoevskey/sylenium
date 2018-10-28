package io.symonk.sylenium.integration.testrail.model;


import java.io.Serializable;


public class TestrailRun implements Serializable {


    private final int suiteId;
    private final String name;
    private final String description;
    private final boolean shouldIncludeAllTests;
    private final int[] testCaseIds;

    public TestrailRun(final int suiteId, final String name, final String description, final boolean shouldIncludeAllTests, final int[] testCaseIds) {
        this.suiteId = suiteId;
        this.name = name;
        this.description = description;
        this.shouldIncludeAllTests = shouldIncludeAllTests;
        this.testCaseIds = testCaseIds;
    }

    public int getSuiteId() {
        return suiteId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isShouldIncludeAllTests() {
        return shouldIncludeAllTests;
    }

    public int[] getTestCaseIds() {
        return testCaseIds;
    }
}
