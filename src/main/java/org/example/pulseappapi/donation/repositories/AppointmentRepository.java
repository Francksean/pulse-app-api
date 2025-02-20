package org.example.pulseappapi.donation.repositories;

import org.example.pulseappapi.donation.enums.AppointmentStatus;
import org.example.pulseappapi.donation.model.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    /**
     * get all appointments for one user
     * @param donorId
     * @param pageable
     */
    public Page<Appointment> findFirstByDonor_Id(Long donorId, Pageable pageable);

    /**
     * get all appointments for one center
     * @param donorId
     * @param pageable
     */
    public Page<Appointment> findFirstByCenter_Id(Long donorId, Pageable pageable);
}
