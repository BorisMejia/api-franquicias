package co.com.franquicias.r2dbc.sucursal;

import co.com.franquicias.r2dbc.entity.SucursalEntity;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

// TODO: This file is just an example, you should delete or modify it
public interface SucursalReactiveRepository extends ReactiveCrudRepository<SucursalEntity, Integer>, ReactiveQueryByExampleExecutor<SucursalEntity> {
    Flux<SucursalEntity> findByIdFranquicia(Integer idFranquicia);
}
