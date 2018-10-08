package io.github.symonk.interactions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthentificationResponse {

    @JsonProperty
    @Getter
    private String token;



}
