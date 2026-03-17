package com.example.LogiTrack.Controller;

import com.example.LogiTrack.Dto.request.BodegaRequestDTO;
import com.example.LogiTrack.Dto.response.BodegaResponseDTO;
import com.example.LogiTrack.Service.BodegaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Bodegas", description = "Procesa todo lo relacionado con Bodegas")
@RestController
@RequestMapping("/bodegas")
public class BodegaController {

    private final BodegaService service;

    public BodegaController(BodegaService service) {
        this.service = service;
    }

    @Operation(summary = "Listar bodegas", description = "Se usa para listar todas las bodegas")
    @GetMapping
    public List<BodegaResponseDTO> listar() {
        return service.listar();
    }

    @Operation(summary = "obtener bodega", description = "Se usa para buscar una bodega por id")
    @GetMapping("/{id}")
    public BodegaResponseDTO obtener(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Crear bodega", description = "Se usa para crear una nueva bodega")
    @PostMapping
    public BodegaResponseDTO crear(@RequestBody BodegaRequestDTO dto) {
        return service.guardar(dto);
    }

    @Operation(summary = "Actualizar bodega", description = "Se usa para actualizar una bodega existente por id")
    @PutMapping("/{id}")
    public BodegaResponseDTO actualizar(@PathVariable Integer id, @RequestBody BodegaRequestDTO dto) {
        return service.actualizar(id, dto);
    }

    @Operation(summary = "Borrar bodega", description = "Se usa para eliminar una bodega existente por id")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}