package com.orlikapp.reservation.application.reservation;

import lombok.Value;

import java.util.Set;

@Value
public class ReservationResponse {
    private final String id;
    private final String streetName;
    private final Long latitude;
    private final Long longitude;
    private final String city;
    private final String ownerEmail;
    private final Set<Player> players;
}
