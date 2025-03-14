package org.example.hollidaybooking.repository;

import org.example.hollidaybooking.models.Reservation;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationRepository {
    private JdbcTemplate jdbcTemplate;

    public ReservationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //get reservations by userName
    public List<Reservation> getReservationsByUserName(String userName) {
        String sql = "select * from reservation where username = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Reservation.class), userName);
    }

    //add reservation
    public int addReservation(int userId, int flightId, int adultsNr, int childsNr) {
        String sql = "insert into Reservations(userID, flightID, numberOfAdults, numberOfChildren) values(?,?,?,?)";
        return jdbcTemplate.update(sql, userId, flightId, adultsNr, childsNr);
    }


}
