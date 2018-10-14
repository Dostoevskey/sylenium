package io.github.symonk.interactions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;

public class Booking {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Booking.class);
    @JsonProperty
    private String firstname;
    @JsonProperty
    private String lastname;
    @JsonProperty
    private int totalprice;
    @JsonProperty
    private boolean depositpaid;
    @JsonProperty
    private BookingDates bookingdates;
    @JsonProperty
    private String additionalneeds;
}
