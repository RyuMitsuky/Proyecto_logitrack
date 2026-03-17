package com.example.LogiTrack.mapper;
import com.example.LogiTrack.Dto.request.ProductoRequestDTO;
import com.example.LogiTrack.Dto.response.ProductoResponseDTO;
import com.example.LogiTrack.Model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public ProductoResponseDTO entidadADTO(Producto producto) {

        if (producto == null) return null;

        return new ProductoResponseDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock()
        );
    }

    public Producto dtoAEntidad(ProductoRequestDTO dto) {

        if (dto == null) return null;

        Producto producto = new Producto();

        producto.setNombre(dto.nombre());
        producto.setDescripcion(dto.descripcion());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());

        return producto;
    }

    public void actualizarEntidad(Producto producto, ProductoRequestDTO dto) {

        producto.setNombre(dto.nombre());
        producto.setDescripcion(dto.descripcion());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());
    }
}