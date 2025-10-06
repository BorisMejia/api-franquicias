package co.com.franquicias.api.franquicia.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para actualizar el nombre de la franquicia")
public record UpdateNombreFranquiciaRequestDto(
        @Schema(description = "ID de la franquicia a modificar", example = "1", required = true)
        Integer idFranquicia,
        @Schema(description = "Nuevo nombre de la franquicia", example = "Accenture", required = true)
        String nuevoNombreFranquicia
) {
}
