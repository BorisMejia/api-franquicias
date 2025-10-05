package co.com.franquicias.r2dbc.franquicia;

import co.com.franquicias.model.franquicia.Franquicia;
import co.com.franquicias.model.franquicia.gateways.FranquiciaRepository;
import co.com.franquicias.model.producto.Producto;
import co.com.franquicias.model.sucursal.Sucursal;
import co.com.franquicias.r2dbc.entity.FranquiciaEntity;
import co.com.franquicias.r2dbc.entity.ProductoEntity;
import co.com.franquicias.r2dbc.helper.ReactiveAdapterOperations;
import co.com.franquicias.r2dbc.sucursal.SucursalReactiveRepository;
import co.com.franquicias.r2dbc.producto.ProductoReactiveRepository;

import java.util.ArrayList;
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

    private final SucursalReactiveRepository sucursalRepository;
    private final ProductoReactiveRepository productoRepository;

    public FranquiciaReactiveRepositoryAdapter(FranquiciaReactiveRepository repository,
                                             ObjectMapper mapper,
                                             SucursalReactiveRepository sucursalRepository,
                                             ProductoReactiveRepository productoRepository) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.mapBuilder(d,Franquicia.FranquiciaBuilder.class).build());
        this.sucursalRepository = sucursalRepository;
        this.productoRepository = productoRepository;
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
                .flatMapMany(franquiciaEntity ->
                        sucursalRepository.findByIdFranquicia(idFranquicia)
                                .flatMap(sucursalEntity ->
                                        productoRepository.findByIdSucursal(sucursalEntity.getIdSucursal())
                                                .collectList()
                                                .map(productos -> {
                                                    ProductoEntity maxProducto = productos.stream()
                                                            .max(Comparator.comparingInt(ProductoEntity::getStock))
                                                            .orElse(null);
                                                    
                                                    List<Producto> productoList = new ArrayList<>();
                                                    if (maxProducto != null) {
                                                        productoList.add(mapper.map(maxProducto, Producto.class));
                                                    }
                                                    Sucursal sucursal = mapper.map(sucursalEntity, Sucursal.class);
                                                    sucursal.setListaProductos(productoList);
                                                    return sucursal;
                                                })
                                )
                                .collectList()
                                .map(sucursales -> {
                                    Franquicia franquicia = mapper.map(franquiciaEntity, Franquicia.class);
                                    franquicia.setListaSucursales(sucursales);
                                    return franquicia;
                                })
                );
    }
}
