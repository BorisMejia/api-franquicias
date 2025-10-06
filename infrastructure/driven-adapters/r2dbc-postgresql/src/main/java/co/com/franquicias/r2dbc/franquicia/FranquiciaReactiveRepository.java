package co.com.franquicias.r2dbc.franquicia;

import co.com.franquicias.r2dbc.entity.FranquiciaEntity;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

// TODO: This file is just an example, you should delete or modify it
public interface FranquiciaReactiveRepository extends ReactiveCrudRepository<FranquiciaEntity, Integer>, ReactiveQueryByExampleExecutor<FranquiciaEntity> {

}
