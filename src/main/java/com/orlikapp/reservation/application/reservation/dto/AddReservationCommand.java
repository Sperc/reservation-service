package com.orlikapp.reservation.application.reservation.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class AddReservationCommand {
    private final Long latitude;
    private final Long longitude;
    private final String streetName;
    private final String city;
    private final LocalDateTime startDateTime;
    private final LocalDateTime endDateTime;
    private final Long playersAmount;
}
