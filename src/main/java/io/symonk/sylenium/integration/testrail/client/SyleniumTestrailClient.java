package io.symonk.sylenium.integration.testrail.client;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.symonk.sylenium.integration.testrail.model.TestrailRun;

import static io.restassured.RestAssured.given;

public class SyleniumTestrailClient {

    private static final String ADD_RUN = "/api/v2/add_run/";
    private final RequestSpecification requestSpecification;
    private int latestRunId = 0;

    public SyleniumTestrailClient(final String username, final String apiKey, final String url) {
        final PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName(username);
        auth.setPassword(apiKey);
        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(url)
                .setAuth(auth)
                .build()
                .log()
                .all();
    }

    public void createNewTestRun(final String project, final TestrailRun run) {
        this.latestRunId = given()
                .spec(requestSpecification)
                .when()
                .body(run)
                .post(ADD_RUN + project)
                .then()
                .extract()
                .path("id");
    }

    public void addResultsForCases() {

    }






}
