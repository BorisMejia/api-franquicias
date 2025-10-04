package co.com.franquicias.r2dbc.sucursal;

import co.com.franquicias.model.sucursal.Sucursal;
import co.com.franquicias.model.sucursal.gateways.SucursalRepository;
import co.com.franquicias.r2dbc.entity.SucursalEntity;
import co.com.franquicias.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

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
        SucursalEntity entity = new SucursalEntity();
        entity.setIdSucursal(idSucursal);
        entity.setNombreSucursal(nombreSucursal);
        entity.setIdFranquicia(idFranquicia);
        return repository.save(entity)
                .map(saved -> mapper.map(saved, Sucursal.class));
    }

    @Override
    public Mono<Sucursal> updateSucursal(Integer idSucursal, String nuevoNombre) {
        return repository.findById(idSucursal)
                .flatMap(entity -> {
                    entity.setNombreSucursal(nuevoNombre);
                    return repository.save(entity);
                })
                .map(updated -> mapper.map(updated, Sucursal.class));
    }

    @Override
    public Mono<Sucursal> findByIdSucursal(Integer idSucursal) {
        return repository.findById(idSucursal)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Sucursal no encontrada con id: " + idSucursal)))
                .map(entity -> Sucursal.builder()
                        .idSucursal(entity.getIdSucursal())
                        .nombreSucursal(entity.getNombreSucursal())
                        .idFranquicia(entity.getIdFranquicia())
                        .listaProductos(new ArrayList<>())
                .build());
    }
}
