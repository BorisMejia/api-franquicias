package co.com.franquicias.model.producto.gateways;

import co.com.franquicias.model.producto.Producto;
import reactor.core.publisher.Mono;

public interface ProductoRepository {
    Mono<Producto> saveProducto(Integer IdSucursal,Integer idProducto, String nombreProducto, Integer stock);
    Mono<Producto> updateNombreProducto(Integer idProducto, String nuevoNombreProducto);
    Mono<Producto> updateStockProducto( Integer idProducto, Integer stock);
    Mono<Void> deleteProducto(Integer idProducto);


}
