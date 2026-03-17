package com.example.LogiTrack.Dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;

public record BodegaRequestDTO(

        @NotBlank(message = "El nombre no puede estar vacío")
        @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
        String nombre,

        @NotBlank(message = "La ubicación no puede estar vacía")
        @Size(min = 2, max = 100, message = "La ubicación debe tener entre 2 y 100 caracteres")
        String ubicacion,

        @NotNull(message = "La capacidad no puede ser nula")
        @Min(value = 1, message = "La capacidad debe ser al menos 1")
        Integer capacidad,

        String encargado

) {}