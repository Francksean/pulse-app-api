package org.example.pulseappapi.authentication.DTOs;

import lombok.Data;

@Data
public class RegisterDTO {
    private String username;
    private String password;
    private String email;
}
