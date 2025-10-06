package co.com.franquicias.api.franquicia.dto.mapper;

import co.com.franquicias.api.franquicia.dto.response.FranquiciaResponseDto;
import co.com.franquicias.api.franquicia.dto.response.ProductoMaxStockResponseDto;
import co.com.franquicias.model.franquicia.Franquicia;
import co.com.franquicias.model.producto.Producto;
import co.com.franquicias.model.sucursal.Sucursal;
import org.mapstruct.Mapper;

import java.util.Collections;

@Mapper(componentModel = "spring")
public interface FranquiciaMapper {
    
    FranquiciaResponseDto toResponse(Franquicia franquicia);
    
    default ProductoMaxStockResponseDto toResponseProductoMax(Franquicia franquicia) {
        var sucursales = franquicia.getListaSucursales() == null 
            ? Collections.<ProductoMaxStockResponseDto.SucursalMaxStockDto>emptyList()
            : franquicia.getListaSucursales().stream()
                .map(sucursal -> toSucursalDto(sucursal))
                .toList();
        
        return ProductoMaxStockResponseDto.builder()
            .idFranquicia(franquicia.getIdFranquicia())
            .nombreFranquicia(franquicia.getNombreFranquicia())
            .sucursales(sucursales)
            .build();
    }
    
    default ProductoMaxStockResponseDto.SucursalMaxStockDto toSucursalDto(Sucursal sucursal) {
        var producto = sucursal.getListaProductos() != null && !sucursal.getListaProductos().isEmpty()
            ? toProductoDto(sucursal.getListaProductos().get(0))
            : null;
        
        return ProductoMaxStockResponseDto.SucursalMaxStockDto.builder()
            .idSucursal(sucursal.getIdSucursal())
            .nombreSucursal(sucursal.getNombreSucursal())
            .productoMaxStock(producto)
            .build();
    }
    
    default ProductoMaxStockResponseDto.ProductoMaxStockDto toProductoDto(Producto producto) {
        return ProductoMaxStockResponseDto.ProductoMaxStockDto.builder()
            .idProducto(producto.getIdProducto())
            .nombreProducto(producto.getNombreProducto())
            .stock(producto.getStock())
            .build();
    }
}
