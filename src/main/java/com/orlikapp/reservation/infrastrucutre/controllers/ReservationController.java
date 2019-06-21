package com.orlikapp.reservation.infrastrucutre.controllers;

import com.orlikapp.reservation.application.reservation.Reservation;
import com.orlikapp.reservation.application.reservation.ReservationFacade;
import com.orlikapp.reservation.application.reservation.dto.AddReservationCommand;
import com.orlikapp.reservation.application.reservation.dto.UserId;
import com.orlikapp.reservation.infrastrucutre.SessionUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationFacade reservationFacade;
    private final SessionUtil sessionUtil;

    @PostMapping
    public Mono<Reservation> addReservation(@RequestBody AddReservationCommand command) {
        final UserId userId = sessionUtil.getLoggedUser();
        log.info("Add reservation request:{} in userId context: {}", command, userId);
        return reservationFacade.addReservation(command, userId);
    }

}
