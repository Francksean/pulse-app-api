package org.example.pulseappapi.notification.repositories;

import org.example.pulseappapi.notification.models.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    /**
     *
     * @param centerId
     * @param pageable
     */
    Page<Notification> findNotificationByCenter_IdAndSeenIsFalse(Long centerId, Pageable pageable);

    /**
     *
     * @param centerId
     * @param pageable
     */
    Page<Notification> findNotificationByCenter_Id(Long centerId, Pageable pageable);
}
