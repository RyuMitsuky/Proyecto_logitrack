package com.example.LogiTrack.Dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BodegaRequestDTO(

        @NotBlank
        String nombre,

        @NotBlank
        String ubicacion,

        @NotNull
        Integer capacidad,

        String encargado

) {}