package com.orlikapp.reservation.application.reservation;

import com.orlikapp.reservation.application.reservation.dto.AddReservationCommand;
import com.orlikapp.reservation.application.reservation.dto.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ReservationFacade {
    private final ReservationService reservationService;

    public Mono<Reservation> addReservation(AddReservationCommand command, UserId userId) {
        return reservationService.addReservation(command, userId);
    }
}
