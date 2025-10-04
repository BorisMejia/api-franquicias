package co.com.franquicias.api.producto.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para registrar un nuevo producto")
public record RegisterProductoRequestDto(
        @Schema(description = "ID de la franquicia donde se encuentra la sucursal", example = "1", required = true)
        Integer idFranquicia,
        @Schema(description = "ID de la sucursal donde se quiere agregar el producto", example = "1", required = true)
        Integer idSucursal,
        @Schema(description = "Nombre del producto a agregar", example = "Aros de Cebolla", required = true)
        String nombreProducto,
        @Schema(description = "Nuevo nombre de la franquicia", example = "Accenture", required = true)
        Integer stock
) {
}
