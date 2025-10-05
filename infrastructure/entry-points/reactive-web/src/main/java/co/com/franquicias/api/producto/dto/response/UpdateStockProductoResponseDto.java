package co.com.franquicias.api.producto.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para devolver el nombre y el nuevo stock del producto")
public record UpdateStockProductoResponseDto(
        @Schema(description = "Nombre del producto", example = "1", required = true)
        String nombreProducto,
        @Schema(description = "Stock actualizado", example = "1", required = true)
        Integer stock
) {
}
