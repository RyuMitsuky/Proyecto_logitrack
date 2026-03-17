package com.example.LogiTrack.Service.impl;
import com.example.LogiTrack.Dto.request.ProductoRequestDTO;
import com.example.LogiTrack.Dto.response.ProductoResponseDTO;
import com.example.LogiTrack.Model.Bodega;
import com.example.LogiTrack.mapper.ProductoMapper;
import com.example.LogiTrack.Model.Producto;
import com.example.LogiTrack.Repository.ProductoRepository;
import com.example.LogiTrack.Service.ProductoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repository;
    private final ProductoMapper mapper;

    public ProductoServiceImpl(ProductoRepository repository, ProductoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductoResponseDTO guardar(ProductoRequestDTO dto) {

        Producto producto = mapper.dtoAEntidad(dto);

        return mapper.entidadADTO(repository.save(producto));
    }

    @Override
    public ProductoResponseDTO actualizar(Integer id, ProductoRequestDTO dto) {

        Producto producto = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        mapper.actualizarEntidad(producto, dto);

        return mapper.entidadADTO(repository.save(producto));
    }

    @Override
    public void eliminar(Integer id) {

        Producto producto = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("producto no encontrada" +id));

        repository.delete(producto);
    }

    @Override
    public List<ProductoResponseDTO> listar() {

        return repository.findAll()
                .stream()
                .map(mapper::entidadADTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoResponseDTO buscarPorId(Integer id) {

        Producto producto = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("producto no encontrada" +id));

        return mapper.entidadADTO(producto);
    }
}