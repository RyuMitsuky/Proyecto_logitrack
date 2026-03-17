package com.example.LogiTrack.Service;

import com.example.LogiTrack.Dto.request.UsuarioRequestDTO;
import com.example.LogiTrack.Dto.response.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {

    UsuarioResponseDTO guardarUsuario(UsuarioRequestDTO dto);

    UsuarioResponseDTO actualizarUsuario(UsuarioRequestDTO dto, Integer id);

    void eliminarUsuario(Integer id);

    List<UsuarioResponseDTO> listarUsuarios();

    UsuarioResponseDTO buscarPorId(Integer id);

    List<UsuarioResponseDTO> buscarPorUsername(String username);
}   