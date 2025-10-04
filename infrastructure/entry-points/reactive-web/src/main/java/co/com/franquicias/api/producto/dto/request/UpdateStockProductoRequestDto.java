package co.com.franquicias.api.producto.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para actualizar el stock de un producto")
public record UpdateStockProductoRequestDto(
        @Schema(description = "ID de la franquicia donde se encuentra la sucursal", example = "1", required = true)
        Integer idFranquicia,
        @Schema(description = "ID de la sucursal donde se encuentra el producto", example = "1", required = true)
        Integer idSucursal,
        @Schema(description = "ID del producto a modificar", example = "1", required = true)
        Integer idProducto,
        @Schema(description = "Nuevo stock para el producto", example = "1", required = true)
        Integer nuevoStock
) {
}
