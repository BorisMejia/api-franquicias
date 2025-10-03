package co.com.franquicias.api.franquicia.dto.mapper;

import co.com.franquicias.api.franquicia.dto.response.FranquiciaResponseDto;
import co.com.franquicias.model.franquicia.Franquicia;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FranquiciaMapper {
    FranquiciaResponseDto toResponse(Franquicia franquicia);
}
