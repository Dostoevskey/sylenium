package io.github.symonk.interactions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;

public class AuthentificationResponse {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(AuthentificationResponse.class);
    @JsonProperty
    private String token;


    public String getToken() {
        return this.token;
    }
}
