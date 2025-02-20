package org.example.pulseappapi.campaign.services;

import org.example.pulseappapi.campaign.DTOs.CampaignRequestDTO;
import org.example.pulseappapi.campaign.DTOs.CampaignResponseDTO;
import org.example.pulseappapi.campaign.enums.CampaignStatus;
import org.example.pulseappapi.campaign.models.Campaign;
import org.example.pulseappapi.campaign.repositories.CampaignRepository;
import org.example.pulseappapi.center_management.repository.CenterRepository;
import org.example.pulseappapi.center_management.models.Center;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private CenterRepository centerRepository;

    public Page<Campaign> getAllCampaigns(Pageable pageable) {
        return campaignRepository.findAll(pageable);
    }

    public Campaign getCampaignById(Long id) {
        return campaignRepository.findById(id).orElse(null);
    }

    public CampaignResponseDTO createCampaign(CampaignRequestDTO request) {
        Center center = centerRepository.findById(request.getCenterId())
                .orElseThrow(null);

        Campaign campaign = new Campaign();
        campaign.setTitle(request.getTitle());
        campaign.setDescription(request.getDescription());
        campaign.setCenter(center);
        campaign.setStartDate(request.getStartDate());
        campaign.setEndDate(request.getEndDate());
        campaign.setStatus(CampaignStatus.ACTIVE);

        campaignRepository.save(campaign);

        return new CampaignResponseDTO(campaign.getId(), campaign.getTitle(), campaign.getDescription(),
                center.getId(), campaign.getStatus());
    }

    public Page<Campaign> getCenterCampaigns(Long centerId, Pageable pageable) {
        return campaignRepository.findByCenterId(centerId, pageable);
    }
}
