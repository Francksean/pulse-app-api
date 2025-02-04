package org.example.pulseappapi.authentication.service;

import lombok.Data;
import org.example.pulseappapi.authentication.models.User;
import org.example.pulseappapi.authentication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User storeUser(User user) {
        return userRepository.save(user);
    }
}
