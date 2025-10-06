package co.com.franquicias.usecase.sucursal;

import co.com.franquicias.model.sucursal.Sucursal;
import reactor.core.publisher.Mono;

public interface ISucursalUseCase {
    Mono<Sucursal> createSucursal(Integer idFranquicia,Integer idSucursal, String nombreSucursal);
    Mono<Sucursal> updateNombreSucursal(Integer idFranquicia, Integer idSucursal, String nuevoNombreSucursal);
    Mono<Sucursal> findByIdSucursal(Integer idFranquicia, Integer IdSucursal);
}
