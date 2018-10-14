package io.github.symonk.interactions.wrappers;

import io.github.symonk.interactions.dto.Booking;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.slf4j.Logger;

import static io.restassured.RestAssured.given;

public class RestfulBookerServiceWrapper extends AbstractWrapperBase {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(RestfulBookerServiceWrapper.class);
    private final String apiEndpoint = getBaseUrl() + "booking/";


    public RestfulBookerServiceWrapper(String base) {
        super(base);
    }

    @Step("Pinging service: Booking API")
    public Response pingService() {
        return given().when().get(getBaseUrl() + "ping");
    }

    @Step("Retrieve a list of all bookings")
    public Response getBookings() {
        return given().spec(getSpec()).get(apiEndpoint);
    }

    @Step("Getting booking {id}")
    public Response getBooking(int id) {
        return given().spec(getSpec()).get(
                apiEndpoint + Integer.toString(id));

    }

    @Step("Saving a new booking")
    public Response postBooking(Booking payload) {
        return given().spec(getSpec()).body(payload).when()
                .post(apiEndpoint);
    }

    @Step("Deleting a booking: {id}")
    public Response deleteBooking(int id, String tokenValue) {
        return given().spec(getSpec()).header("Cookie", "token=" + tokenValue).delete(
                apiEndpoint + Integer.toString(id));
    }

}