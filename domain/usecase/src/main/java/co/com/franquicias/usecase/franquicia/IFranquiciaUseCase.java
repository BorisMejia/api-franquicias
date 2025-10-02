package co.com.franquicias.usecase.franquicia;

import co.com.franquicias.model.franquicia.Franquicia;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IFranquiciaUseCase {
    Mono<Franquicia> createFranquicia(Integer idFranquicia, String nombreFranquicia);
    Flux<Franquicia> findAllFranquicia();
    Mono<Franquicia> findByIdFranquicia(Integer idFranquicia);
    Mono<Franquicia> updateNombreFranquicia(Integer idFranquicia, String nuevoNombreFranquicia);
    Mono<Void> deleteFranquicia(Integer idFranquicia);
}
