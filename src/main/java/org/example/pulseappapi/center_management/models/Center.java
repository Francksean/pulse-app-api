package org.example.pulseappapi.center_management.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.pulseappapi.campaign.models.Campaign;
import org.example.pulseappapi.center_management.enums.AccreditationStatus;
import org.example.pulseappapi.donation.model.Appointment;
import org.example.pulseappapi.notification.models.Notification;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "centers")
@AllArgsConstructor
@NoArgsConstructor
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String longitude;

    @Column
    private String latitude;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column
    private String email;

    @Column(name = "open_hours")
    private String openHours;

    @Enumerated(EnumType.STRING)
    private AccreditationStatus accreditationStatus = AccreditationStatus.PENDING;

    @Column
    private LocalDateTime lastCampaignDate;

    @ElementCollection
    private List<String> documentUrls;

    @OneToMany(mappedBy = "center", cascade = CascadeType.ALL)
    private List<Campaign> campaigns;

    @OneToMany(mappedBy = "center", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "center", cascade = CascadeType.ALL)
    private List<Notification> notifications;

    @Column(name = "center_logo")
    private String centerLogo;

    @Column(name = "center_banner")
    private String centerBanner;
}
