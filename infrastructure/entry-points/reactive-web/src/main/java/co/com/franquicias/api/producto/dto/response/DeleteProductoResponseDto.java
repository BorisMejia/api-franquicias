package co.com.franquicias.api.producto.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de respuesta para eliminación de producto")
public record DeleteProductoResponseDto(
    @Schema(description = "Mensaje de confirmación", example = "Producto eliminado correctamente")
    String mensaje
) {
}