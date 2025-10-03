package co.com.franquicias.r2dbc.franquicia;

import co.com.franquicias.model.franquicia.Franquicia;
import co.com.franquicias.model.franquicia.gateways.FranquiciaRepository;
import co.com.franquicias.r2dbc.entity.FranquiciaEntity;
import co.com.franquicias.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class FranquiciaReactiveRepositoryAdapter extends ReactiveAdapterOperations<
        Franquicia/* change for domain model */,
        FranquiciaEntity/* change for adapter model */,
    Integer,
        FranquiciaReactiveRepository
> implements FranquiciaRepository {
    public FranquiciaReactiveRepositoryAdapter(FranquiciaReactiveRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.mapBuilder(d,Franquicia.FranquiciaBuilder.class).build());
    }

    @Override
    public Mono<Franquicia> saveFranquicia(Franquicia franquicia) {
        return null;
    }

    @Override
    public Mono<Franquicia> findByIdFranquicia(Integer idFranquicia) {
        return null;
    }

    @Override
    public Flux<Franquicia> findByAllFranquicias() {
        return null;
    }

    @Override
    public Mono<Franquicia> updateFranquicia(Integer id, String nombreFranquicia) {
        return null;
    }

    @Override
    public Mono<Void> deleteFranquicia(Integer idFranquicia) {
        return null;
    }

    @Override
    public Flux<Franquicia> findProductoWithMaxStockBySucursal(Integer idFranquicia) {
        return null;
    }
}
