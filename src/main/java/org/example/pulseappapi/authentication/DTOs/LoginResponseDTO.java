package org.example.pulseappapi.authentication.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.pulseappapi.core.user.DTOs.UserDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private UserDTO user;
    private String token;
    private Long expiresIn;
}
