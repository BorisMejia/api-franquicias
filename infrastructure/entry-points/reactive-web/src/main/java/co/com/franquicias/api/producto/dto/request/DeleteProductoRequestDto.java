package co.com.franquicias.api.producto.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para eliminar un producto")
public record DeleteProductoRequestDto(
        @Schema(description = "ID de la franquicia donde se encuentra la sucursal", example = "1", required = true)
        Integer idFranquicia,
        @Schema(description = "ID de la sucursal donde se encuentra el producto", example = "1", required = true)
        Integer idSucursal,
        @Schema(description = "ID del producto a eliminar", example = "1", required = true)
        Integer idProducto
) {
}
