package com.example.LogiTrack.mapper;
import com.example.LogiTrack.Dto.request.UsuarioRequestDTO;
import com.example.LogiTrack.Dto.response.UsuarioResponseDTO;
import com.example.LogiTrack.Model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    // Convierte entidad Usuario a UsuarioResponseDTO
    public UsuarioResponseDTO entidadADTO(Usuario usuario) {
        if (usuario == null) return null;
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getRol()
        );
    }

    // Convierte UsuarioRequestDTO a entidad Usuario
    public Usuario DTOAEntidad(UsuarioRequestDTO dto) {
        if (dto == null) return null;
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.username());
        usuario.setPassword(dto.password());
        usuario.setRol(dto.rol());
        return usuario;
    }

    // Actualiza entidad Usuario existente con datos del DTO
    public void actualizarEntidadDesdeDTO(Usuario usuario, UsuarioRequestDTO dto) {
        if (dto == null || usuario == null) return;
        usuario.setUsername(dto.username());
        usuario.setPassword(dto.password());
        usuario.setRol(dto.rol());
    }
}