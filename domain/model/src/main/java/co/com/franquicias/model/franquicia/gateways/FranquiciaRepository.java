package co.com.franquicias.model.franquicia.gateways;

import co.com.franquicias.model.franquicia.Franquicia;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranquiciaRepository {

    Mono<Franquicia> saveFranquicia(Franquicia franquicia);
    Mono<Franquicia> findByIdFranquicia (Integer idFranquicia);
    Flux<Franquicia> findByAllFranquicias();
    Mono<Franquicia> updateFranquicia(Integer id, String nombreFranquicia);
    Mono<Void> deleteFranquicia(Integer idFranquicia);
}
