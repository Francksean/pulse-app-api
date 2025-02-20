package org.example.pulseappapi.notification.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.pulseappapi.center_management.models.Center;

@Data
@Entity(name = "notifications")
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "center_id")
    private Center center;
    @Column
    private String title;
    @Column
    private String body;
    @Column
    private boolean seen;
}
