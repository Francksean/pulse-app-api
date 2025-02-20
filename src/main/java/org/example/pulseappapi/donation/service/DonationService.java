package org.example.pulseappapi.donation.service;

import org.example.pulseappapi.core.user.services.UserService;
import org.example.pulseappapi.donation.model.Donation;
import org.example.pulseappapi.donation.repositories.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DonationService {
    @Autowired
    DonationRepository donationRepository;
    @Autowired
    UserService userService;

    public Donation registerDonation(Donation donation) {
        donationRepository.save(donation);
        return donation;
    }

    public Page<Donation> getUserDonations(Long userId, Pageable pageable) {
        return donationRepository.findFirstByDonor_Id(userId, pageable);
    }

    public Page<Donation> getCampaignDonations(Long campaignId, Pageable pageable) {
        return donationRepository.findFirstByCampaign_Id(campaignId, pageable);
    }
}
