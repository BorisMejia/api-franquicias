package co.com.franquicias.usecase.producto;

import co.com.franquicias.model.franquicia.gateways.FranquiciaRepository;
import co.com.franquicias.model.producto.Producto;
import co.com.franquicias.model.producto.gateways.ProductoRepository;
import co.com.franquicias.model.sucursal.gateways.SucursalRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ProductoUseCase implements IProductoUseCase {

    private final FranquiciaRepository franquiciaRepository;
    private final ProductoRepository productoRepository;
    private final SucursalRepository sucursalRepository;
    @Override
    public Mono<Producto> createProducto(Integer idFranquicia, Integer idSucursal, Integer idProducto, String nombreProducto, Integer stock) {
        return franquiciaRepository.findByIdFranquicia(idFranquicia)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No existe una franquicia con el id: " + idFranquicia)))
                .flatMap(sucursal -> sucursalRepository.findByIdSucursal(idSucursal))
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No existe una sucursal con el id: " + idSucursal)))
                .flatMap(producto -> {
                    if (nombreProducto == null || nombreProducto.trim().isEmpty())
                        return Mono.error(new IllegalArgumentException("El nombre del producto no permitido"));
                    if (stock < 0)
                        return Mono.error(new IllegalArgumentException("El valor del stock no permitido"));
                    return productoRepository.saveProducto(idSucursal, idProducto, nombreProducto, stock);
                })
                ;
    }

    @Override
    public Mono<Void> deleteProducto(Integer idFranquicia, Integer idSucursal, Integer idProducto) {
        return franquiciaRepository.findByIdFranquicia(idFranquicia)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No existe una franquicia con el id: " + idFranquicia)))
                .flatMap(sucursal -> sucursalRepository.findByIdSucursal(idSucursal))
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No existe una sucursal con el id: " + idSucursal)))
                .flatMap(producto -> productoRepository.deleteProducto(idProducto))
                ;
    }

    @Override
    public Mono<Producto> updateStock(Integer idFranquicia, Integer idSucursal, Integer idProducto, Integer nuevoStock) {
        return franquiciaRepository.findByIdFranquicia(idFranquicia)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No existe una franquicia con el id: " + idFranquicia)))
                .flatMap(sucursal -> sucursalRepository.findByIdSucursal(idSucursal))
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No existe una sucursal con el id: " + idSucursal)))
                .flatMap(producto -> {
                    if (nuevoStock == null || nuevoStock < 0)
                        return Mono.error(new IllegalArgumentException("El stock no puede ser negativo"));
                    return productoRepository.updateStockProducto(idProducto, nuevoStock);
                });
    }

    @Override
    public Mono<Producto> updateNombreProducto(Integer idFranquicia, Integer idSucursal, Integer idProducto, String nuevoNombreProducto) {
        return franquiciaRepository.findByIdFranquicia(idFranquicia)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No existe una franquicia con el id: " + idFranquicia)))
                .flatMap(sucursal -> sucursalRepository.findByIdSucursal(idSucursal))
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No existe una sucursal con el id: " + idSucursal)))
                .flatMap(producto -> {
                    if (nuevoNombreProducto == null || nuevoNombreProducto.trim().isEmpty()) {
                        return Mono.error(new IllegalArgumentException("El nombre del producto no puede estar vacío"));
                    }
                    if (nuevoNombreProducto.trim().length() > 30) {
                        return Mono.error(new IllegalArgumentException("El nombre del producto no puede exceder 30 caracteres"));
                    }
                    return productoRepository.updateNombreProducto(idProducto, nuevoNombreProducto.trim());
                })
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No se encontró un producto con el id: " + idProducto)));
    }
}
