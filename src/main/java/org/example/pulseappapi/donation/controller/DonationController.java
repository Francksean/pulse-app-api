package org.example.pulseappapi.donation.controller;

import org.example.pulseappapi.donation.model.Donation;
import org.example.pulseappapi.donation.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/donations")
public class DonationController {
    @Autowired
    private DonationService donationService;

    @GetMapping("/{userId}")
    public ResponseEntity<Page<Donation>> getUserDonations(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize) {
        final Pageable pageable = PageRequest.of(page, pageSize);
        return ResponseEntity.ok(donationService.getUserDonations(userId, pageable));
    }


}
