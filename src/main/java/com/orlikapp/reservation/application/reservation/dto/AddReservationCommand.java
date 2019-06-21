package com.orlikapp.reservation.application.reservation.dto;

import lombok.Value;

@Value
public class AddReservationCommand {
    private final Long latitude;
    private final Long longitude;
    private final String streetName;
    private final String city;
}
