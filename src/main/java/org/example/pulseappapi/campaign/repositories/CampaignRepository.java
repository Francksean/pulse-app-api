package org.example.pulseappapi.campaign.repositories;

import org.example.pulseappapi.campaign.models.Campaign;
import org.example.pulseappapi.donation.model.Donation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    /**
     * get all campaigns relatives to a center
     * @param centerId
     * @param pageable
     */
    Page<Campaign> findByCenterId(Long centerId, Pageable pageable);

    /**
     * effectuer la recherche pour une campagne
     * @param subTitle
     * @param pageable
     */
    Page<Campaign> findByTitleContaining(String subTitle, Pageable pageable);

}
