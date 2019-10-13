package com.orlikapp.reservation.application.reservation;

import com.orlikapp.reservation.application.adapters.dto.UserData;
import com.orlikapp.reservation.application.reservation.dto.AddReservationCommand;
import com.orlikapp.reservation.application.reservation.dto.AddReservationResponse;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
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
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Long playerAmount;

    Reservation update(AddReservationCommand command, UserData owner) {
        this.location = new Location(
                command.getStreetName(),
                command.getLatitude(),
                command.getLongitude(),
                command.getCity());
        this.ownerEmail = owner.getEmail();
        this.startDateTime = command.getStartDateTime();
        this.endDateTime = command.getEndDateTime();
        this.playerAmount = command.getPlayersAmount();
        return this;
    }

    AddReservationResponse createAddReservationResponse() {
        return new AddReservationResponse(this.getId());
    }
}
