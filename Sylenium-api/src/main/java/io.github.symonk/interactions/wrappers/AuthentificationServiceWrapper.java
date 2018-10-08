package io.github.symonk.interactions.wrappers;

import io.github.symonk.interactions.dto.Authentification;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthentificationServiceWrapper extends AbstractWrapperBase {

    public AuthentificationServiceWrapper(String base) {
        super(base);
    }

    private final String apiEndpoint = getBaseUrl() + "auth/";

    public Response postAuth(Authentification payload){
        return given().spec(getSpec())
                .body(payload)
                .when()
                .post(apiEndpoint);
    }
}
