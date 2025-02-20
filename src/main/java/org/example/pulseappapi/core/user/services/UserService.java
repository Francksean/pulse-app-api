package org.example.pulseappapi.core.user.services;

import org.example.pulseappapi.core.user.repositories.UserRepository;
import org.example.pulseappapi.donation.model.Donation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Donation> fetchUserDonations(Long id, Pageable pageable){
        return userRepository.findById(id).orElseThrow(null).getDonations();
    }
}
