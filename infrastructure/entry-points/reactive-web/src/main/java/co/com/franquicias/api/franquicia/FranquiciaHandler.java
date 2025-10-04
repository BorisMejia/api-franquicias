package co.com.franquicias.api.franquicia;

import co.com.franquicias.api.franquicia.dto.mapper.FranquiciaMapper;
import co.com.franquicias.api.franquicia.dto.request.RegisterFranquiciaDto;
import co.com.franquicias.api.franquicia.dto.request.UpdateNombreFranquiciaRequestDto;
import co.com.franquicias.usecase.franquicia.FranquiciaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FranquiciaHandler {

    private final FranquiciaUseCase franquiciaUseCase;
    private final FranquiciaMapper franquiciaMapper;

    public Mono<ServerResponse> registerFranquicia(ServerRequest request){
        return request.bodyToMono(RegisterFranquiciaDto.class)
                .flatMap(registerFranquicia -> franquiciaUseCase.createFranquicia(
                        null,
                        registerFranquicia.nombreFranquicia()
                ))
                .map(franquiciaMapper::toResponse)
                .flatMap(responseRegister -> ServerResponse.ok().bodyValue(responseRegister));
    }
    public Mono<ServerResponse> updateFranquicia(ServerRequest request){
        return request.bodyToMono(UpdateNombreFranquiciaRequestDto.class)
                .flatMap(updateNombreFranquicia -> franquiciaUseCase.updateNombreFranquicia(
                        updateNombreFranquicia.idFranquicia(),
                        updateNombreFranquicia.nuevoNombreFranquicia()
                ))
                .map(franquiciaMapper::toResponse)
                .flatMap(responseUpdate -> ServerResponse.ok().bodyValue(responseUpdate));
    }

}
