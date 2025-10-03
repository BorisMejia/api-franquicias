package co.com.franquicias.r2dbc.franquicia;

import co.com.franquicias.model.franquicia.Franquicia;
import co.com.franquicias.model.franquicia.gateways.FranquiciaRepository;
import co.com.franquicias.model.producto.Producto;
import co.com.franquicias.r2dbc.entity.FranquiciaEntity;
import co.com.franquicias.r2dbc.helper.ReactiveAdapterOperations;

import java.util.Comparator;
import java.util.List;

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
        FranquiciaEntity entity = mapper.map(franquicia, FranquiciaEntity.class);
        return repository.save(entity)
                .map(saved -> mapper.map(saved, Franquicia.class));
    }

    @Override
    public Mono<Franquicia> findByIdFranquicia(Integer idFranquicia) {
        return repository.findById(idFranquicia)
                .map(entity -> mapper.map(entity, Franquicia.class));
    }

    @Override
    public Flux<Franquicia> findByAllFranquicias() {
        return repository.findAll()
                .map(entity -> mapper.map(entity, Franquicia.class));
    }

    @Override
    public Mono<Franquicia> updateFranquicia(Integer id, String nombreFranquicia) {
        return repository.findById(id)
                .flatMap(entity -> {
                    entity.setNombreFranquicia(nombreFranquicia);
                    return repository.save(entity);
                })
                .map(updated -> mapper.map(updated, Franquicia.class));
    }

    @Override
    public Mono<Void> deleteFranquicia(Integer idFranquicia) {
        return repository.deleteById(idFranquicia);
    }

    @Override
    public Flux<Franquicia> findProductoWithMaxStockBySucursal(Integer idFranquicia) {
        return repository.findById(idFranquicia)
            .map(entity -> {
                if (entity.getListaSucursales() != null) {
                    entity.getListaSucursales().forEach(sucursal -> {
                        if (sucursal.getListaProductos() != null && !sucursal.getListaProductos().isEmpty()) {
                            Producto maxStockProducto = sucursal.getListaProductos().stream()
                                    .max(Comparator.comparingInt(Producto::getStock))
                                .orElse(null);
                            List<Producto> productosMax = maxStockProducto != null
                                ? List.of(mapper.map(maxStockProducto, Producto.class))
                                : List.of();
                            sucursal.setListaProductos(productosMax);
                        } else {
                            sucursal.setListaProductos(List.of());
                        }
                    });
                }
                return mapper.map(entity, Franquicia.class);
            })
            .flux();
    }
}
