package org.example.pulseappapi.campaign.controllers;

import org.example.pulseappapi.campaign.DTOs.CampaignRequestDTO;
import org.example.pulseappapi.campaign.DTOs.CampaignResponseDTO;
import org.example.pulseappapi.campaign.models.Campaign;
import org.example.pulseappapi.campaign.services.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/campaigns")
public class CampaignController {

    @Autowired
    CampaignService campaignService;

    @GetMapping("/")
    public ResponseEntity<Page<Campaign>> getCampaigns(@RequestParam int page, @RequestParam int pageSize) {
        final Pageable pageable = PageRequest.of(page, pageSize);
        return ResponseEntity.ok(campaignService.getAllCampaigns(pageable));
    }

    @PostMapping("/new")
    public ResponseEntity<CampaignResponseDTO> createCampaign(@RequestBody CampaignRequestDTO campaign) {
        return ResponseEntity.ok(campaignService.createCampaign(campaign));
    }

    @GetMapping("/{campaignId}")
    public ResponseEntity<Campaign> getCampaign(@PathVariable Long campaignId) {
        return ResponseEntity.ok(campaignService.getCampaignById(campaignId));
    }

    @GetMapping("/{centerId}/campaigns")
    public ResponseEntity<Page<Campaign>> getCenterCampaigns(@PathVariable Long centerId, @RequestParam int page, @RequestParam int pageSize) {
        final Pageable pageable = PageRequest.of(page, pageSize);
        return ResponseEntity.ok(campaignService.getCenterCampaigns(centerId, pageable));
    }
}
