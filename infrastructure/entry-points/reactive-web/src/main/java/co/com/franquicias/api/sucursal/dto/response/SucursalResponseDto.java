package co.com.franquicias.api.sucursal.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de respuesta con los datos de la sucursal creada")
public record SucursalResponseDto(
        @Schema(description = "ID único de la sucursal", example = "1")
        Integer idSucursal,
        @Schema(description = "Nombre de la sucursal", example = "Sucursal Bogotá")
        String nombreSucursal
) {
}
