package org.example.pulseappapi.donation.model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.pulseappapi.center_management.models.Center;
import org.example.pulseappapi.core.user.models.User;
import org.example.pulseappapi.donation.enums.AppointmentStatus;

import java.util.Date;

@Data
@Entity
@Table(name = "Appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User donor;

    @ManyToOne
    @JoinColumn(name = "center_id")
    private Center center;

    @Column(name = "apppointment_date")
    private Date appointmentDate;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
}
