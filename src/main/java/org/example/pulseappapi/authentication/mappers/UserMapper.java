package org.example.pulseappapi.authentication.mappers;

import org.example.pulseappapi.core.user.DTOs.UserDTO;
import org.example.pulseappapi.core.user.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    public User toUser(UserDTO userDTO);
    public UserDTO toUserDTO(User user);
}
