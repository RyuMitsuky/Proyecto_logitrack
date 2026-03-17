package com.example.LogiTrack.Service;

import com.example.LogiTrack.Dto.request.BodegaRequestDTO;
import com.example.LogiTrack.Dto.response.BodegaResponseDTO;

import java.util.List;

public interface BodegaService {

    BodegaResponseDTO guardar(BodegaRequestDTO dto);

    BodegaResponseDTO actualizar(Integer id, BodegaRequestDTO dto);

    void eliminar(Integer id);

    List<BodegaResponseDTO> listar();

    BodegaResponseDTO buscarPorId(Integer id);
}