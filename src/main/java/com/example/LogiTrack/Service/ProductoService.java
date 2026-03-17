package com.example.LogiTrack.Service;

import com.example.LogiTrack.Dto.request.ProductoRequestDTO;
import com.example.LogiTrack.Dto.response.ProductoResponseDTO;

import java.util.List;

public interface ProductoService {

    ProductoResponseDTO guardar(ProductoRequestDTO dto);

    ProductoResponseDTO actualizar(Integer id, ProductoRequestDTO dto);

    void eliminar(Integer id);

    List<ProductoResponseDTO> listar();

    ProductoResponseDTO buscarPorId(Integer id);
}