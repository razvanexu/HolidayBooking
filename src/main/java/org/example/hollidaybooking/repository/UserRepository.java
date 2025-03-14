package org.example.hollidaybooking.repository;

import org.example.hollidaybooking.models.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Create
    public int addUser(User user) {
        String sql ="insert into users(id, name, password) values(null,?,?)";
        return jdbcTemplate.update(sql);
    }

    //check user
    public boolean register(String userName, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        return jdbcTemplate.update(sql, userName, password) != 0;
    }

    public Optional<User> getUserByCredentials(String username, String password) {
        String sql = "select * from users where username = ? and password = ? ";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), username, password);
        if (users.isEmpty()) {
            return Optional.empty();
        }else {
            return Optional.of(users.get(0));
        }
    }
}
