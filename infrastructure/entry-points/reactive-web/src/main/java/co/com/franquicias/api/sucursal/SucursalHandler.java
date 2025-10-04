package co.com.franquicias.api.sucursal;

import co.com.franquicias.api.sucursal.dto.mapper.SucursalMapper;
import co.com.franquicias.api.sucursal.dto.request.RegisterSucursalRequestDto;
import co.com.franquicias.usecase.sucursal.SucursalUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class SucursalHandler {
    private final SucursalUseCase sucursalUseCase;
    private final SucursalMapper sucursalMapper;

    public Mono<ServerResponse> createSucursal(ServerRequest request){
        return request.bodyToMono(RegisterSucursalRequestDto.class)
                .flatMap(createSucursal -> sucursalUseCase.createSucursal(
                        createSucursal.idFranquicia(),
                        null,
                        createSucursal.nombreSucursal()
                ))
                .map(sucursalMapper::toResponse)
                .flatMap(responseCreate -> ServerResponse.ok().bodyValue(responseCreate));
    }

}
