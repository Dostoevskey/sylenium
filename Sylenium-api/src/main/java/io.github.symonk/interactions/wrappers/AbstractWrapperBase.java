package io.github.symonk.interactions.wrappers;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class AbstractWrapperBase {
    private final RequestSpecification spec;
    private final String baseUrl;


    public AbstractWrapperBase(String base) {
        this.baseUrl = base;
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON).setBaseUri(baseUrl)
                .addFilter(new AllureRestAssured()).build();
    }






}