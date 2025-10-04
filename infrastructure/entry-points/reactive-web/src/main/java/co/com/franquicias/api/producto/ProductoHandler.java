package co.com.franquicias.api.producto;

import co.com.franquicias.api.producto.dto.mapper.ProductoMapper;
import co.com.franquicias.api.producto.dto.request.RegisterProductoRequestDto;
import co.com.franquicias.api.sucursal.dto.request.RegisterSucursalRequestDto;
import co.com.franquicias.usecase.producto.ProductoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductoHandler {
    private final ProductoUseCase productoUseCase;
    private final ProductoMapper productoMapper;

    public Mono<ServerResponse> createProducto(ServerRequest request){
        return request.bodyToMono(RegisterProductoRequestDto.class)
                .flatMap(createProducto -> productoUseCase.createProducto(
                        createProducto.idFranquicia(),
                        createProducto.idSucursal(),
                        null,
                        createProducto.nombreProducto(),
                        createProducto.stock()
                ))
                .map(productoMapper::toResponse)
                .flatMap(responseCreate -> ServerResponse.ok().bodyValue(responseCreate));
    }

}
