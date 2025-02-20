package org.example.pulseappapi.center_management.repository;

import org.example.pulseappapi.center_management.models.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends JpaRepository<Center, Long> {
}
