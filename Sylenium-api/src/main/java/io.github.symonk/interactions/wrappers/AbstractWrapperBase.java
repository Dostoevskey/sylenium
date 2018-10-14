package io.github.symonk.interactions.wrappers;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;

public class AbstractWrapperBase {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(AbstractWrapperBase.class);
    private final RequestSpecification spec;
    private final String baseUrl;


    public AbstractWrapperBase(String base) {
        this.baseUrl = base;
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON).setBaseUri(baseUrl)
                .addFilter(new AllureRestAssured()).build();
    }


    public RequestSpecification getSpec() {
        return this.spec;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof AbstractWrapperBase)) return false;
        final AbstractWrapperBase other = (AbstractWrapperBase) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$spec = this.getSpec();
        final Object other$spec = other.getSpec();
        if (this$spec == null ? other$spec != null : !this$spec.equals(other$spec)) return false;
        final Object this$baseUrl = this.getBaseUrl();
        final Object other$baseUrl = other.getBaseUrl();
        if (this$baseUrl == null ? other$baseUrl != null : !this$baseUrl.equals(other$baseUrl)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $spec = this.getSpec();
        result = result * PRIME + ($spec == null ? 43 : $spec.hashCode());
        final Object $baseUrl = this.getBaseUrl();
        result = result * PRIME + ($baseUrl == null ? 43 : $baseUrl.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof AbstractWrapperBase;
    }

    public String toString() {
        return "AbstractWrapperBase(spec=" + this.getSpec() + ", baseUrl=" + this.getBaseUrl() + ")";
    }
}