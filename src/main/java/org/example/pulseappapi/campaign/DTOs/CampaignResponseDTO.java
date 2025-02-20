package org.example.pulseappapi.campaign.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.pulseappapi.campaign.enums.CampaignStatus;


/**
 * DTO de réponse après la création d'une campagne de don
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampaignResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Long donationCenterId;
    private CampaignStatus status;
}
