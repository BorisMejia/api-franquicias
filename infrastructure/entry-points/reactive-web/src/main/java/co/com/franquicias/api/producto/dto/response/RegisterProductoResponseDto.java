package co.com.franquicias.api.producto.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record RegisterProductoResponseDto(
        @Schema(description = "ID del producto agregado", example = "1", required = true)
        Integer idProducto,
        @Schema(description = "Nombre del producto agregado", example = "Aros de Cebolla", required = true)
        String nombreProducto,
        @Schema(description = "Numero total de productos en stock", example = "30", required = true)
        Integer stock
) {
}
