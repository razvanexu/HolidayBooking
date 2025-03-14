package org.example.hollidaybooking.repository;

import org.example.hollidaybooking.models.Flight;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class FlightRepository {
    private JdbcTemplate jdbcTemplate;

    public FlightRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //get all flights
    public List<Flight> getAllFlights() {
        String sql = "select * from Flights";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Flight.class));
    }

    //get flight by departure, arrival, departureDate, arrivalDate
    public List<Flight> getFlightsByParams(String departure, String arrival,
                                           Date departureDate, Date arrivalDate) {
        String sql = "select * from Flights where departure = ? AND arrival = ?" +
                        "AND departureDate >= ? AND arrivalDate <= ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Flight.class),departure, arrival,
                                                                    departureDate, arrivalDate);
    }

    //get flight by id
    public Flight getFlightById(int id) {
        String sql = "select * from Flights where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Flight.class), id);
    }

    public List<Flight> getTestFlights(){
        String sql = "select * from Flights Where departureDate = '2023-10-01'";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Flight.class));
    }


}
