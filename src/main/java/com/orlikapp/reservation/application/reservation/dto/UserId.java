package com.orlikapp.reservation.application.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(staticName = "of")
public class UserId {
    private String email;
}
