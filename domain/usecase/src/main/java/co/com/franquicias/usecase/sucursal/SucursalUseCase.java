package co.com.franquicias.usecase.sucursal;

import co.com.franquicias.model.franquicia.gateways.FranquiciaRepository;
import co.com.franquicias.model.sucursal.Sucursal;
import co.com.franquicias.model.sucursal.gateways.SucursalRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SucursalUseCase implements ISucursalUseCase{

    private final FranquiciaRepository franquiciaRepository;
    private final SucursalRepository sucursalRepository;
    @Override
    public Mono<Sucursal> createSucursal(Integer idFranquicia, Integer idSucursal, String nombreSucursal) {
        return franquiciaRepository.findByIdFranquicia(idFranquicia)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No existe una franquicia con el id: " + idFranquicia)))
                .flatMap(franquicia -> sucursalRepository.saveSucursal(idFranquicia, idSucursal, nombreSucursal));
    }

    @Override
    public Mono<Sucursal> updateNombreSucursal(Integer idFranquicia, Integer idSucursal, String nuevoNombreSucursal) {
        return franquiciaRepository.findByIdFranquicia(idFranquicia)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No existe una franquicia con el id: " + idFranquicia)))
                .flatMap(franquicia -> sucursalRepository.updateSucursal(idFranquicia, idSucursal, nuevoNombreSucursal));
    }
}
