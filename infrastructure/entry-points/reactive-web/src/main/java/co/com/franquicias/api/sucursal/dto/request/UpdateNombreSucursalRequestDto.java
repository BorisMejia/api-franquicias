package co.com.franquicias.api.sucursal.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para actualizar el nombre de una sucursal")
public record UpdateNombreSucursalRequestDto(
        @Schema(description = "ID de la franquicia donde se encuentra la sucursal", example = "1", required = true)
        Integer idFranquicia,
        @Schema(description = "ID de la sucursal a actualizar", example = "1", required = true)
        Integer idSucursal,
        @Schema(description = "Nuevo nombre para la sucursal", example = "Bogota", required = true)
        String nuevoNombreSucursal
) {
}
