package com.example.LogiTrack.Dto.response;

public record ProductoResponseDTO(

        Integer id,
        String nombre,
        String descripcion,
        Double precio,
        Integer stock

) {}