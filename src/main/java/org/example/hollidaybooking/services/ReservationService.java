package org.example.hollidaybooking.services;

import org.example.hollidaybooking.models.Reservation;
import org.example.hollidaybooking.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservationsByUsername(String username) {
        return reservationRepository.getReservationsByUserName(username);
    }

    public int addReservation(int userId, int flightId, int numberOfAdults, int numberOfChildren) {
        return reservationRepository.addReservation(userId, flightId, numberOfAdults, numberOfChildren);
    }
}
