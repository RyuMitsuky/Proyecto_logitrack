package com.example.LogiTrack.Service.impl;

import com.example.LogiTrack.Dto.request.BodegaRequestDTO;
import com.example.LogiTrack.Dto.response.BodegaResponseDTO;
import com.example.LogiTrack.mapper.BodegaMapper;
import com.example.LogiTrack.Model.Bodega;
import com.example.LogiTrack.Repository.BodegaRepository;
import com.example.LogiTrack.Service.BodegaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BodegaServiceImpl implements BodegaService {

    private final BodegaRepository repository;
    private final BodegaMapper mapper;

    public BodegaServiceImpl(BodegaRepository repository, BodegaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public BodegaResponseDTO guardar(BodegaRequestDTO dto) {

        Bodega bodega = mapper.dtoAEntidad(dto);

        return mapper.entidadADTO(repository.save(bodega));
    }

    @Override
    public BodegaResponseDTO actualizar(Integer id, BodegaRequestDTO dto) {

        Bodega bodega = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bodega no encontrada"));

        mapper.actualizarEntidad(bodega, dto);

        return mapper.entidadADTO(repository.save(bodega));
    }

    @Override
    public void eliminar(Integer id) {

        Bodega bodega = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bodega no encontrada"));

        repository.delete(bodega);
    }

    @Override
    public List<BodegaResponseDTO> listar() {

        return repository.findAll()
                .stream()
                .map(mapper::entidadADTO)
                .collect(Collectors.toList());
    }

    @Override
    public BodegaResponseDTO buscarPorId(Integer id) {

        Bodega bodega = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bodega no encontrada"));

        return mapper.entidadADTO(bodega);
    }
}