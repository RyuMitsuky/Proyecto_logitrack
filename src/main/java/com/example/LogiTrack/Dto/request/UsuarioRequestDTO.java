package com.example.LogiTrack.Dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDTO(

        @Schema(description = "Nombre de usuario", example = "admin")
        @NotBlank(message = "El username no puede estar vacío")
        String username,

        @Schema(description = "Contraseña del usuario", example = "admin123")
        @NotBlank(message = "La contraseña no puede estar vacía")
        String password,

        @Schema(description = "Rol del usuario", example = "ADMIN")
        @NotBlank(message = "El rol no puede estar vacío")
        String rol

) {}