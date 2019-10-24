package com.orlikapp.reservation.application.reservation.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Value
public class AddReservationCommand {
    private final Long latitude;
    private final Long longitude;
    private final String streetName;
    private final String city;
    private final LocalDateTime startDateTime;
    private final LocalDateTime endDateTime;
    private final Long playersAmount;

    @JsonCreator
    public AddReservationCommand(@JsonProperty("latitude") Long latitude,
                                 @JsonProperty("longitude") Long longitude,
                                 @JsonProperty("streetName") String streetName,
                                 @JsonProperty("city") String city,
                                 @JsonProperty("startDateTime") String startDateTime,
                                 @JsonProperty("endDateTime") String endDateTime,
                                 @JsonProperty("playersAmount") Long playersAmount) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.latitude = latitude;
        this.longitude = longitude;
        this.streetName = streetName;
        this.city = city;
        this.startDateTime = LocalDateTime.parse(startDateTime, formatter);
        this.endDateTime = LocalDateTime.parse(endDateTime, formatter);
        this.playersAmount = playersAmount;
    }
}
