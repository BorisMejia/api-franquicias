package co.com.franquicias.usecase.producto;

import co.com.franquicias.model.producto.Producto;
import reactor.core.publisher.Mono;

public interface IProductoUseCase {
    Mono<Producto> createProducto(Integer idFranquicia, Integer idSucursal, Integer idProducto, String nombreProducto, Integer stock);
    Mono<Void> deleteProducto(Integer idFranquicia, Integer idSucursal, Integer idProducto);
    Mono<Producto> updateStock(Integer idFranquicia, Integer idSucursal, Integer idProducto, Integer nuevoStock);
    Mono<Producto> updateNombreProducto(Integer idFranquicia, Integer idSucursal, Integer idProducto, String nuevoNombreProducto);
}
