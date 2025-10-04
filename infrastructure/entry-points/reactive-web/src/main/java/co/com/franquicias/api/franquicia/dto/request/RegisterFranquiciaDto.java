package co.com.franquicias.api.franquicia.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para registrar una nueva franquicia")
public record RegisterFranquiciaDto(
        
        @Schema(description = "Nombre descriptivo de la franquicia", example = "McDonald's", required = true)
        String nombreFranquicia
) {
}
