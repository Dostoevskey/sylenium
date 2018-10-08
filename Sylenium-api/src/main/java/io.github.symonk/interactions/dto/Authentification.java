package io.github.symonk.interactions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public class Authentification {

    @JsonProperty
    private final String username;
    @JsonProperty
    private final String password;

}
