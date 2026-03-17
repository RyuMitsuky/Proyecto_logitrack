package com.example.LogiTrack.Dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;

public record ProductoRequestDTO(

        @NotBlank(message = "El nombre no puede estar vacío")
        @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
        String nombre,

        String descripcion,

        @NotNull(message = "El precio no puede ser nulo")
        @Min(value = 0, message = "El precio debe ser positivo")
        Double precio,

        @NotNull(message = "El stock no puede ser nulo")
        @Min(value = 0, message = "El stock no puede ser negativo")
        Integer stock

) {}