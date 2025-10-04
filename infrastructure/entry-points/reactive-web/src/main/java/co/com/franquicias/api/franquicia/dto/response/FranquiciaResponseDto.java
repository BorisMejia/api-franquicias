package co.com.franquicias.api.franquicia.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de respuesta con los datos de la franquicia registrada")
public record FranquiciaResponseDto (
        @Schema(description = "ID único de la franquicia", example = "1")
        Integer idFranquicia,
        
        @Schema(description = "Nombre de la franquicia", example = "McDonald's")
        String nombreFranquicia
){
}