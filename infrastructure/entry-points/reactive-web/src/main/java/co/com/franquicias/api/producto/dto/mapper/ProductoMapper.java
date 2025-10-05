package co.com.franquicias.api.producto.dto.mapper;

import co.com.franquicias.api.producto.dto.response.RegisterProductoResponseDto;
import co.com.franquicias.api.producto.dto.response.UpdateNombreProductoResponseDto;
import co.com.franquicias.api.producto.dto.response.UpdateStockProductoResponseDto;
import co.com.franquicias.model.producto.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    RegisterProductoResponseDto toResponse(Producto producto);
    UpdateStockProductoResponseDto toResponseUpdate(Producto producto);
    UpdateNombreProductoResponseDto toResponseUpdateNombre(Producto producto);
}
