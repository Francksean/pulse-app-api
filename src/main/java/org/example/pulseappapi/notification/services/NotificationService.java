package org.example.pulseappapi.notification.services;

import org.example.pulseappapi.notification.DTOs.CreateNotificationDTO;
import org.example.pulseappapi.notification.models.Notification;
import org.example.pulseappapi.notification.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public Notification registerNotification(CreateNotificationDTO notification) {
        final Notification newNotification = new Notification();
        newNotification.setTitle(notification.getTitle());
        newNotification.setBody(notification.getBody());
        newNotification.setCenter(notification.getCenter());
        return notificationRepository.save(newNotification);
    }
    public Notification getNotification(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public Page<Notification> getCenterNotSeenNotifications(Long centerId, Pageable pageable) {
        return notificationRepository.findNotificationByCenter_IdAndSeenIsFalse(centerId, pageable);
    }

    public Page<Notification> getCenterNotifications(Long centerId, Pageable pageable) {
        return notificationRepository.findNotificationByCenter_Id(centerId, pageable);
    }
}
