package com.orlikapp.reservation.application.adapters.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserData {
    private String uuid;
    private String email;
    private String firstName;
    private String lastName;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public UserData(@JsonProperty("uuid") String uuid,
                    @JsonProperty("email") String email,
                    @JsonProperty("firstName") String firstName,
                    @JsonProperty("lastName") String lastName) {
        this.uuid = uuid;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
