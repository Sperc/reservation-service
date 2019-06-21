package com.orlikapp.reservation.application.reservation;

import lombok.Value;

@Value
class Location {
    private String streetName;
    private Long latitude;
    private Long longitude;
    private String city;
}
