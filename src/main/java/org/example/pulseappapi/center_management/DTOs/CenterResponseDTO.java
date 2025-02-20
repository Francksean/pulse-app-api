package org.example.pulseappapi.center_management.DTOs;

import lombok.Data;

import java.util.List;

/**
 * DTO de réponse après l'enregistrement d'un centre de don
 */
@Data
public class CenterResponseDTO {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private Double latitude;
    private Double longitude;
    private String accreditationStatus;
    private List<String> documentUrls;
}
