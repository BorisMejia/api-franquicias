package co.com.franquicias.api.producto.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para devolver el nombre actualizado y el stock del producto")
public record UpdateNombreProductoResponseDto(
        @Schema(description = "Nombre actualizado del producto", example = "1", required = true)
        String nombreProducto,
        @Schema(description = "Stock del producto", example = "1", required = true)
        String stock
) {
}
