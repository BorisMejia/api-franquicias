package co.com.franquicias.r2dbc.sucursal;

import co.com.franquicias.model.sucursal.Sucursal;
import co.com.franquicias.model.sucursal.gateways.SucursalRepository;
import co.com.franquicias.r2dbc.entity.SucursalEntity;
import co.com.franquicias.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class SucursalReactiveRepositoryAdapter extends ReactiveAdapterOperations<
        Sucursal/* change for domain model */,
        SucursalEntity/* change for adapter model */,
    Integer,
        SucursalReactiveRepository
> implements SucursalRepository {
    public SucursalReactiveRepositoryAdapter(SucursalReactiveRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.mapBuilder(d,Sucursal.SucursalBuilder.class).build());
    }

    @Override
    public Mono<Sucursal> saveSucursal(Integer idFranquicia, Integer idSucursal, String nombreSucursal) {
        return null;
    }

    @Override
    public Mono<Sucursal> updateSucursal(Integer idFranquicia, Integer idSucursal, String nuevoNombre) {
        return null;
    }
}
