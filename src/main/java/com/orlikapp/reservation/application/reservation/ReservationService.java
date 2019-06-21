package com.orlikapp.reservation.application.reservation;

import com.orlikapp.reservation.application.adapters.DataManagementAdapter;
import com.orlikapp.reservation.application.reservation.dto.AddReservationCommand;
import com.orlikapp.reservation.application.reservation.dto.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
class ReservationService {
    private final ReservationRepository reservationRepository;
    private final DataManagementAdapter dataManagementAdapter;

    Mono<Reservation> addReservation(AddReservationCommand command, UserId userId) {
        return dataManagementAdapter.getUser(userId.getEmail())
                                    .map(userData -> new Reservation().update(command, userData))
                                    .map(reservationRepository::save);
    }

}
