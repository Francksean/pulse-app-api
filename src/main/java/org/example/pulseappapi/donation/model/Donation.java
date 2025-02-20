package org.example.pulseappapi.donation.model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.pulseappapi.campaign.models.Campaign;
import org.example.pulseappapi.core.user.models.User;
import org.example.pulseappapi.donation.enums.DonationType;

@Data
@Entity
@Table(name = "blood_donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User donor;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign = null;

    @Column
    private Long center;

    @Column(name = "donor_name")
    private String donorName;

    @Column(name = "blood_quantity")
    private int bloodQuantity;

    @Column
    private String notes;

    @Column
    @Enumerated(EnumType.STRING)
    private DonationType donationType;

    @Column
    private Long appointment;
}
