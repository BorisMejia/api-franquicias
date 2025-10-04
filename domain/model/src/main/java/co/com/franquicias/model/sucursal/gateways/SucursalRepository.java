package co.com.franquicias.model.sucursal.gateways;

import co.com.franquicias.model.sucursal.Sucursal;
import reactor.core.publisher.Mono;

public interface SucursalRepository {
    Mono<Sucursal> saveSucursal(Integer idFranquicia, Integer idSucursal, String nombreSucursal);
    Mono<Sucursal> updateSucursal(Integer idSucursal, String nuevoNombre);
    Mono<Sucursal> findByIdSucursal(Integer idSucursal);

}
