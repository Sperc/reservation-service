package com.orlikapp.reservation.application.reservation;

import org.springframework.data.mongodb.repository.MongoRepository;

interface ReservationRepository extends MongoRepository<Reservation, String> {
}
