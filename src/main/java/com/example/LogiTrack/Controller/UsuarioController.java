package com.example.LogiTrack.Controller;

import com.example.LogiTrack.Dto.request.UsuarioRequestDTO;
import com.example.LogiTrack.Dto.response.UsuarioResponseDTO;
import com.example.LogiTrack.Service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Usuarios", description = "Procesa todo lo relacionado con Usuarios")
@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Operation (summary = "Listar usuarios", description = "Se usa para listar todos los usuarios")
    @GetMapping
    public List<UsuarioResponseDTO> listar() {
        return usuarioService.listarUsuarios();
    }

    @Operation (summary = "Buscar usuario", description = "Se usa para buscar un usuario por id")
    @GetMapping("/{id}")
    public UsuarioResponseDTO obtener(@PathVariable Integer id) {
        return usuarioService.buscarPorId(id);
    }

    @Operation (summary = "Guardar usuario", description = "Se usa para guardar un nuevo usuario")
    @PostMapping
    public UsuarioResponseDTO crear(@RequestBody UsuarioRequestDTO dto) {
        return usuarioService.guardarUsuario(dto);
    }

    @Operation (summary = "Actualizar usuario", description = "Se usa para actualizar un usuario(id) existente")
    @PutMapping("/{id}")
    public UsuarioResponseDTO actualizar(@PathVariable Integer id, @RequestBody UsuarioRequestDTO dto) {
        return usuarioService.actualizarUsuario(dto, id);
    }

    @Operation (summary = "Borrar usuario", description = "Se usa para borrar un usuario(id) existente")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        usuarioService.eliminarUsuario(id);
    }
}
