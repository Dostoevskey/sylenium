package io.github.symonk.interactions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;

public class BookingResponse {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BookingResponse.class);
    @JsonProperty
    private int bookingid;
    @JsonProperty
    private Booking booking;

    public int getBookingid() {
        return this.bookingid;
    }

    public Booking getBooking() {
        return this.booking;
    }
}
