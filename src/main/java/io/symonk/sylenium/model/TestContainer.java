package io.symonk.sylenium.model;

import lombok.Data;

import java.util.UUID;

@Data
public class TestContainer {

    private final int caseId;
    private final String caseDescription;
    private int status = -1;
    private String uniqueId = UUID.randomUUID().toString();

    public TestContainer(final int caseId, final String caseDescription) {
        this.caseId = caseId;
        this.caseDescription = caseDescription;
    }


    @Override
    public String toString() {
        return String.format("Test: %s With Case ID: %s Had a status of %s", caseDescription, caseId, status);
    }


}
