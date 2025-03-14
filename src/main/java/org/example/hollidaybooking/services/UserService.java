package org.example.hollidaybooking.services;

import org.example.hollidaybooking.models.User;
import org.example.hollidaybooking.repository.UserRepository;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(String username, String password) {
        return userRepository.register(username, password);
    }

    public Optional<User> getUserByCredentials(String name, String password) {
        return userRepository.getUserByCredentials(name, password);
    }
}
