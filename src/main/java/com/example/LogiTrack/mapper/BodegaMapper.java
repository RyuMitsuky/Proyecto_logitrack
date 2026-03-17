package com.example.LogiTrack.mapper;

import com.example.LogiTrack.Dto.request.BodegaRequestDTO;
import com.example.LogiTrack.Dto.response.BodegaResponseDTO;
import com.example.LogiTrack.Model.Bodega;
import org.springframework.stereotype.Component;

@Component
public class BodegaMapper {

    public BodegaResponseDTO entidadADTO(Bodega bodega) {

        if (bodega == null) return null;

        return new BodegaResponseDTO(
                bodega.getId(),
                bodega.getNombre(),
                bodega.getUbicacion(),
                bodega.getCapacidad(),
                bodega.getEncargado()
        );
    }

    public Bodega dtoAEntidad(BodegaRequestDTO dto) {

        if (dto == null) return null;

        Bodega bodega = new Bodega();

        bodega.setNombre(dto.nombre());
        bodega.setUbicacion(dto.ubicacion());
        bodega.setCapacidad(dto.capacidad());
        bodega.setEncargado(dto.encargado());

        return bodega;
    }

    public void actualizarEntidad(Bodega bodega, BodegaRequestDTO dto) {

        bodega.setNombre(dto.nombre());
        bodega.setUbicacion(dto.ubicacion());
        bodega.setCapacidad(dto.capacidad());
        bodega.setEncargado(dto.encargado());
    }
}