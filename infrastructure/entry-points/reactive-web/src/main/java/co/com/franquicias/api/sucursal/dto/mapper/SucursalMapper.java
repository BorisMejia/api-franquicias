package co.com.franquicias.api.sucursal.dto.mapper;

import co.com.franquicias.api.sucursal.dto.response.SucursalResponseDto;
import co.com.franquicias.model.sucursal.Sucursal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SucursalMapper {
        SucursalResponseDto toResponse(Sucursal sucursal);
}
