package co.com.franquicias.api.franquicia.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record ProductoMaxStockResponseDto(
        Integer idFranquicia,
        String nombreFranquicia,
        List<SucursalMaxStockDto> sucursales
) {
    @Builder
    public record SucursalMaxStockDto(
            Integer idSucursal,
            String nombreSucursal,
            ProductoMaxStockDto productoMaxStock
    ) {}
    
    @Builder
    public record ProductoMaxStockDto(
            Integer idProducto,
            String nombreProducto,
            Integer stock
    ) {}
}