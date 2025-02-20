package org.example.pulseappapi.authentication.DTOs;

import lombok.Data;

@Data
public class LoginDTO {
    private String email;
    private String password;
}
