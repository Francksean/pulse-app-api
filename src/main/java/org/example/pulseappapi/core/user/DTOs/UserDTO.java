package org.example.pulseappapi.core.user.DTOs;

import lombok.Data;
import org.example.pulseappapi.authentication.enums.BloodType;
import org.example.pulseappapi.authentication.enums.GenderType;

import java.util.Date;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date birthDate;
    private GenderType gender;
    private String address;
    private BloodType bloodType;
    private String userBanner;
    private String profilePicture;
    private Date lastDonationDate;
}
