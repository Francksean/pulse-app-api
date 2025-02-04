package org.example.pulseappapi.authentication.DTO;

import lombok.Data;

@Data
public class LoginResponseDTO {
    public UserDTO user;
    public String token;
    public Long expiresIn;
}
