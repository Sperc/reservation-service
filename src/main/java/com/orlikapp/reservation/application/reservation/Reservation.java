package com.orlikapp.reservation.application.reservation;

import com.orlikapp.reservation.application.adapters.dto.UserData;
import com.orlikapp.reservation.application.reservation.dto.AddReservationCommand;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Document
public class Reservation {
    @Id
    private String id = UUID.randomUUID().toString();
    private Location location;
    private String ownerEmail;
    private Set<Player> players = new HashSet<>();

    Reservation update(AddReservationCommand command, UserData owner) {
        this.location = new Location(
                command.getStreetName(),
                command.getLatitude(),
                command.getLongitude(),
                command.getCity());
        this.ownerEmail = owner.getEmail();
        return this;
    }
}
