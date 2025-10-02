package co.com.franquicias.model.producto.gateways;

import co.com.franquicias.model.producto.Producto;
import reactor.core.publisher.Mono;

public interface ProductoRepository {
    Mono<Producto> saveProducto(Integer idFranquicia, Integer idSucursal, Integer idProducto, String nombreProducto, Integer stock);
    Mono<Producto> updateNombreProducto(Integer idFranquicia, Integer idSucursal, Integer idProducto, String nuevoNombreProducto);
    Mono<Producto> updateStockProducto(Integer idFranquicia, Integer idSucursal, Integer idProducto, Integer stock);
    Mono<Void> deleteProducto(Integer idFranquicia, Integer idSucursal, Integer idProducto);

}
