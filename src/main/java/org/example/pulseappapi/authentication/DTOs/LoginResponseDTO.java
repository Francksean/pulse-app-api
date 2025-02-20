package org.example.pulseappapi.authentication.DTOs;

import lombok.Data;
import org.example.pulseappapi.core.user.DTOs.UserDTO;

@Data
public class LoginResponseDTO {
    public UserDTO user;
    public String token;
    public Long expiresIn;
}
