package com.example.LogiTrack.Dto.response;

public record UsuarioResponseDTO(
        Integer id,
        String username,
        String password,
        String rol
) {}