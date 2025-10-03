package co.com.franquicias.usecase.franquicia;

import co.com.franquicias.model.franquicia.Franquicia;
import co.com.franquicias.model.franquicia.gateways.FranquiciaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FranquiciaUseCase implements IFranquiciaUseCase{

    private final FranquiciaRepository franquiciaRepository;
    @Override
    public Mono<Franquicia> createFranquicia(Integer idFranquicia, String nombreFranquicia) {
        return franquiciaRepository.findByIdFranquicia(idFranquicia)
                .flatMap(exists -> Mono.<Franquicia>error(new IllegalArgumentException("Ya existe una franquicia con este id: " + idFranquicia)))
                .switchIfEmpty(franquiciaRepository.saveFranquicia(new Franquicia(idFranquicia, nombreFranquicia)))
                ;
    }

    @Override
    public Flux<Franquicia> findAllFranquicia() {
        return franquiciaRepository.findByAllFranquicias();
    }

    @Override
    public Mono<Franquicia> findByIdFranquicia(Integer idFranquicia) {
        return franquiciaRepository.findByIdFranquicia(idFranquicia);
    }

    @Override
    public Mono<Franquicia> updateNombreFranquicia(Integer idFranquicia, String nuevoNombreFranquicia) {
        return franquiciaRepository.findByIdFranquicia(idFranquicia)
                .map(updateFranquicia -> {
                    updateFranquicia.setNombreFranquicia(nuevoNombreFranquicia);
                    return updateFranquicia;
                })
                .flatMap(franquiciaRepository::saveFranquicia);
    }

    @Override
    public Mono<Void> deleteFranquicia(Integer idFranquicia) {
        return franquiciaRepository.findByIdFranquicia(idFranquicia)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No existe una franquicia con el id: " + idFranquicia)))
                .flatMap(franquicia -> franquiciaRepository.deleteFranquicia(idFranquicia));
    }
}
