package org.example.pulseappapi.donation.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAppointmentDTO {
    private Long donorId;
    private Long centerId;
    private Date appointmentDate;
    private Optional<String> description;
}
