package org.example.pulseappapi.campaign.DTOs;

import lombok.Data;

import java.time.LocalDateTime;


/**
 * DTO pour créer une campagne de don
 */
@Data
public class CampaignRequestDTO {
    private String title;
    private String description;
    private Long CenterId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
