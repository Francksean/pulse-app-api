package org.example.pulseappapi.center_management.DTOs;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * DTO pour l'enregistrement d'un centre de don de sang
 */
@Data
public class CenterRequestDTO {

    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String latitude;
    private String longitude;

    private List<MultipartFile> documents;
}

