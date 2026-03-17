package com.example.LogiTrack.Service.impl;

import com.example.LogiTrack.Dto.request.UsuarioRequestDTO;
import com.example.LogiTrack.Dto.response.UsuarioResponseDTO;
import com.example.LogiTrack.Model.Usuario;
import com.example.LogiTrack.Repository.UsuarioRepository;
import com.example.LogiTrack.Service.UsuarioService;
import com.example.LogiTrack.mapper.UsuarioMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public UsuarioResponseDTO guardarUsuario(UsuarioRequestDTO dto) {

        Usuario usuario = usuarioMapper.DTOAEntidad(dto);

        usuario = usuarioRepository.save(usuario);

        return usuarioMapper.entidadADTO(usuario);
    }

    @Override
    public UsuarioResponseDTO actualizarUsuario(UsuarioRequestDTO dto, Integer id) {

        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + id));

        usuarioMapper.actualizarEntidadDesdeDTO(usuarioExistente, dto);

        usuarioExistente = usuarioRepository.save(usuarioExistente);

        return usuarioMapper.entidadADTO(usuarioExistente);
    }

    @Override
    public void eliminarUsuario(Integer id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + id));

        usuarioRepository.delete(usuario);
    }

    @Override
    public List<UsuarioResponseDTO> listarUsuarios() {

        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::entidadADTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO buscarPorId(Integer id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + id));

        return usuarioMapper.entidadADTO(usuario);
    }

    @Override
    public List<UsuarioResponseDTO> buscarPorUsername(String username) {

        return usuarioRepository.findAll()
                .stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .map(usuarioMapper::entidadADTO)
                .collect(Collectors.toList());
    }
}