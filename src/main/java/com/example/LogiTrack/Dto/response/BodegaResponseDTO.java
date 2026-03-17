package com.example.LogiTrack.Dto.response;

public record BodegaResponseDTO(

        Integer id,
        String nombre,
        String ubicacion,
        Integer capacidad,
        String encargado

) {}