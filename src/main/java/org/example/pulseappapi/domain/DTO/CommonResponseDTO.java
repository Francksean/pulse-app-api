package org.example.pulseappapi.domain.DTO;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CommonResponseDTO<T> {
    private T data;
    private boolean success;
    private String message;

}
