package com.example.LogiTrack.Controller;

import com.example.LogiTrack.Dto.request.ProductoRequestDTO;
import com.example.LogiTrack.Dto.response.ProductoResponseDTO;
import com.example.LogiTrack.Service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Productos", description = "Procesa todo lo relacionado con Productos")
@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @Operation(summary = "Listar Productos", description = "Se usa para listar todas las bodegas existentes")
    @GetMapping
    public List<ProductoResponseDTO> listar() {
        return service.listar();
    }

    @Operation(summary = "Buscar producto", description = "Se usa para buscar un producto por id")
    @GetMapping("/{id}")
    public ProductoResponseDTO obtener(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "crear producto", description = "Se usa para crear un nuevo producto")
    @PostMapping
    public ProductoResponseDTO crear(@RequestBody ProductoRequestDTO dto) {
        return service.guardar(dto);
    }

    @Operation(summary = "Actualizar producto", description = "Se usa para actualizar un producto existente por id")
    @PutMapping("/{id}")
    public ProductoResponseDTO actualizar(@PathVariable Integer id, @RequestBody ProductoRequestDTO dto) {
        return service.actualizar(id, dto);
    }

    @Operation(summary = "Borrar producto", description = "Se usa para borrar un producto existente por id")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}