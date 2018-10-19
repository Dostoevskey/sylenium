package io.github.symonk.testcases;

import io.github.symonk.interactions.wrappers.AuthentificationServiceWrapper;
import io.github.symonk.interactions.wrappers.RestfulBookerServiceWrapper;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.slf4j.Logger;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

public class RestfulBookerServiceTest {


    private static final Logger log = org.slf4j.LoggerFactory.getLogger(RestfulBookerServiceTest.class);
    private RestfulBookerServiceWrapper restfulBookerServiceWrapper;
    private AuthentificationServiceWrapper authentificationServiceWrapper;

    @Inject
    public RestfulBookerServiceTest(final RestfulBookerServiceWrapper bookerWrapper, final AuthentificationServiceWrapper authWrapper) {
        this.restfulBookerServiceWrapper = bookerWrapper;
        this.authentificationServiceWrapper = authWrapper;
    }

    @Test
    @DisplayName("Testing retrieving a valid booking")
    @Issue("001")
    @TmsLink("001")
    @Severity(SeverityLevel.CRITICAL)
    public void getBookingIdShouldReturn200() {
        Response response = restfulBookerServiceWrapper.getBooking(1);
        assertThat(response.getStatusCode()).isEqualTo(200);
    }




}
