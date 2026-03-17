package com.example.LogiTrack.Dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductoRequestDTO(

        @NotBlank
        String nombre,

        String descripcion,

        @NotNull
        Double precio,

        @NotNull
        Integer stock

) {}