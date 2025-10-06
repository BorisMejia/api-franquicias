package co.com.franquicias.api.franquicia.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para obtener el id de la franquicia")
public record FranquiciaRequestDto(
        @Schema(description = "ID de la franquicia para obtener productos", example = "1", required = true)
        Integer idFranquicia
) {
}
