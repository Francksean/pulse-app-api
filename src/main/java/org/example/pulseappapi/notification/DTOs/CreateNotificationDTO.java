package org.example.pulseappapi.notification.DTOs;

import lombok.Data;
import org.example.pulseappapi.center_management.models.Center;

@Data
public class CreateNotificationDTO {
    private String title;
    private String body;
    private Center center;
}
