package org.example.pulseappapi.campaign.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.pulseappapi.campaign.enums.CampaignStatus;
import org.example.pulseappapi.center_management.models.Center;
import org.example.pulseappapi.donation.model.Donation;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Campaign {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String title;

        @Column(nullable = false)
        private String description;

        @ManyToOne
        @JoinColumn(name = "center_id", nullable = false)
        private Center center;

        @OneToMany(mappedBy = "donations")
        private List<Donation> donations;

        @Column(nullable = false)
        private LocalDateTime startDate;

        @Column(nullable = false)
        private LocalDateTime endDate;

        @Enumerated(EnumType.STRING)
        private CampaignStatus status;


}
