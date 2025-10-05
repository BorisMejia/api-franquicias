package co.com.franquicias.api.sucursal.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para devolver el id y nombre actualizado de la sucursal")
public record UpdateNombreSucursalResponseDto(
        @Schema(description = "ID de la sucursal actualizada", example = "1", required = true)
        Integer idSucursal,
        @Schema(description = "Nombre actualizado de la sucursal", example = "Bogota", required = true)
        String nombreSucursal
) {
}
