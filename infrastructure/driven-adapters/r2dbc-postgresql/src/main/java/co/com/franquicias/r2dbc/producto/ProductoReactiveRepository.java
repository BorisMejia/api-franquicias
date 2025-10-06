package co.com.franquicias.r2dbc.producto;

import co.com.franquicias.r2dbc.entity.ProductoEntity;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

// TODO: This file is just an example, you should delete or modify it
public interface ProductoReactiveRepository extends ReactiveCrudRepository<ProductoEntity, Integer>, ReactiveQueryByExampleExecutor<ProductoEntity> {

    Flux<ProductoEntity> findByIdSucursal(Integer idSucursal);
}
