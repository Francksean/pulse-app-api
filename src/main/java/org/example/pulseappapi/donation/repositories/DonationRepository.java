package org.example.pulseappapi.donation.repositories;

import org.example.pulseappapi.donation.model.Donation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    /**
     * get all user's donations
     * @param donorId
     * @param pageable
     */
    public Page<Donation> findFirstByDonor_Id(Long donorId, Pageable pageable);

    /**
     * find all donations relatives to a campaign
     * @param campaignId
     * @param pageable
     */
    public Page<Donation> findFirstByCampaign_Id(Long campaignId, Pageable pageable);
}
