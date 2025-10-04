package co.com.franquicias.api.sucursal.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para registrar una nueva sucursal por franquicia")
public record RegisterSucursalRequestDto(
        @Schema(description = "ID de una Franquicia Existente", example = "1", required = true)
        Integer idFranquicia,
        @Schema(description = "Nombre descriptivo de la sucursal", example = "Sucursal Medellín", required = true)
        String nombreSucursal
) {
}
