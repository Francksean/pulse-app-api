package org.example.pulseappapi.donation.DTOs;

import org.example.pulseappapi.donation.enums.DonationType;

import java.util.Date;
import java.util.Optional;

public class DonationDTO {
    private Long donor;
    private Long center;
    private DonationType donationType;
    private Date donationDate;
    private int bloodQuantity;
    private Optional<Long> appointment;
}
