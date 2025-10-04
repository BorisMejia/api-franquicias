package co.com.franquicias.r2dbc.producto;

import co.com.franquicias.model.producto.Producto;
import co.com.franquicias.model.producto.gateways.ProductoRepository;
import co.com.franquicias.model.sucursal.Sucursal;
import co.com.franquicias.r2dbc.entity.ProductoEntity;
import co.com.franquicias.r2dbc.entity.SucursalEntity;
import co.com.franquicias.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class ProductoReactiveRepositoryAdapter extends ReactiveAdapterOperations<
        Producto/* change for domain model */,
        ProductoEntity/* change for adapter model */,
    Integer,
        ProductoReactiveRepository
> implements ProductoRepository {
    public ProductoReactiveRepositoryAdapter(ProductoReactiveRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.mapBuilder(d,Producto.ProductoBuilder.class).build());
    }

    @Override
    public Mono<Producto> saveProducto(Integer IdSucursal, Integer idProducto, String nombreProducto, Integer stock) {
        ProductoEntity entity = new ProductoEntity();
        entity.setIdSucursal(IdSucursal);
        entity.setNombreProducto(nombreProducto);
        entity.setStock(stock);
        return repository.save(entity)
                .map(saved -> mapper.map(saved, Producto.class));
    }
    @Override
    public Mono<Producto> updateNombreProducto(Integer idProducto, String nuevoNombreProducto) {
        return repository.findById(idProducto)
                .flatMap(entity -> {
                    entity.setNombreProducto(nuevoNombreProducto);
                    return repository.save(entity);
                })
                .map(updated -> mapper.map(updated, Producto.class));
    }

    @Override
    public Mono<Producto> updateStockProducto( Integer idProducto, Integer stock) {
        return repository.findById(idProducto)
                .flatMap(entity -> {
                    entity.setStock(stock);
                    return repository.save(entity);
                })
                .map(updated -> mapper.map(updated, Producto.class));
    }

    @Override
    public Mono<Void> deleteProducto(Integer idProducto) {
        return repository.deleteById(idProducto);
    }
}
