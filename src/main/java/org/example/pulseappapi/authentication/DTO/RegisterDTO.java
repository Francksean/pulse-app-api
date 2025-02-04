package org.example.pulseappapi.authentication.DTO;

import lombok.Data;

@Data
public class RegisterDTO {
    public String username;
    public String password;
    public String email;
}
