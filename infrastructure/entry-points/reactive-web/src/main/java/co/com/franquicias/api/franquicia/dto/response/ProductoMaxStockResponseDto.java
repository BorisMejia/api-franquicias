package co.com.franquicias.api.franquicia.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

@Builder
@Schema(description = "DTO para responder los productos con mayor stock")
public record ProductoMaxStockResponseDto(
        @Schema(description = "ID de la franquicia para obtener productos", example = "1", required = true)
        Integer idFranquicia,
        @Schema(description = "Nombre de la franquicia", example = "McDonald's", required = true)
        String nombreFranquicia,
        @Schema(description = "Lista de todas las sucursales")
        List<SucursalMaxStockDto> sucursales
) {
    @Builder
    @Schema(description = "DTO de respuesta de la sucursal donde se encuentra el producto")
    public record SucursalMaxStockDto(
            @Schema(description = "ID de la sucursal donde se encuentra el producto", example = "1", required = true)
            Integer idSucursal,
            @Schema(description = "Nombre de la sucursal", example = "Medellin", required = true)
            String nombreSucursal,
            @Schema(description = "DTO de con los datos del producto con mayor stock por sucursal")
            ProductoMaxStockDto productoMaxStock
    ) {}
    
    @Builder
    @Schema(description = "DTO de con los datos del producto con mayor stock por sucursal")
    public record ProductoMaxStockDto(
            @Schema(description = "ID del producto con mayor stock", example = "1", required = true)
            Integer idProducto,
            @Schema(description = "Nombre del producto", example = "Hamburguesa", required = true)
            String nombreProducto,
            @Schema(description = "Stock del producto", example = "157", required = true)
            Integer stock
    ) {}
}