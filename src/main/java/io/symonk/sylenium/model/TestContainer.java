package io.symonk.sylenium.model;

import java.util.UUID;

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


    public int getCaseId() {
        return this.caseId;
    }

    public String getCaseDescription() {
        return this.caseDescription;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TestContainer)) return false;
        final TestContainer other = (TestContainer) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getCaseId() != other.getCaseId()) return false;
        final Object this$caseDescription = this.getCaseDescription();
        final Object other$caseDescription = other.getCaseDescription();
        if (this$caseDescription == null ? other$caseDescription != null : !this$caseDescription.equals(other$caseDescription))
            return false;
        if (this.getStatus() != other.getStatus()) return false;
        final Object this$uniqueId = this.getUniqueId();
        final Object other$uniqueId = other.getUniqueId();
        if (this$uniqueId == null ? other$uniqueId != null : !this$uniqueId.equals(other$uniqueId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TestContainer;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getCaseId();
        final Object $caseDescription = this.getCaseDescription();
        result = result * PRIME + ($caseDescription == null ? 43 : $caseDescription.hashCode());
        result = result * PRIME + this.getStatus();
        final Object $uniqueId = this.getUniqueId();
        result = result * PRIME + ($uniqueId == null ? 43 : $uniqueId.hashCode());
        return result;
    }
}
