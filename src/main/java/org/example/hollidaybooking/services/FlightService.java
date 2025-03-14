package org.example.hollidaybooking.services;

import org.example.hollidaybooking.models.Flight;
import org.example.hollidaybooking.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class FlightService {
    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.getAllFlights();
    }

    public Flight getFlightById(int id) {
        return flightRepository.getFlightById(id);
    }

    public List<Flight> getTestFlights() {
        return flightRepository.getTestFlights();
    }

    public List<Flight> getFlightsByParams(String departure, String arrival,
                                           Date departureDate, Date arrivalDate) {

        return flightRepository.getFlightsByParams(departure, arrival, departureDate, arrivalDate);
    }
}
