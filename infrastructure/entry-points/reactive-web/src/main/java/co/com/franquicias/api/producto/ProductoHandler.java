package co.com.franquicias.api.producto;

import co.com.franquicias.api.producto.dto.mapper.ProductoMapper;
import co.com.franquicias.api.producto.dto.request.DeleteProductoRequestDto;
import co.com.franquicias.api.producto.dto.request.RegisterProductoRequestDto;
import co.com.franquicias.api.producto.dto.request.UpdateStockProductoRequestDto;
import co.com.franquicias.api.producto.dto.response.DeleteProductoResponseDto;
import co.com.franquicias.usecase.producto.IProductoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductoHandler {
    private final IProductoUseCase productoUseCase;
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

    public Mono<ServerResponse> updateStock(ServerRequest request){
        return request.bodyToMono(UpdateStockProductoRequestDto.class)
                .flatMap(updateStock -> productoUseCase.updateStock(
                        updateStock.idFranquicia(),
                        updateStock.idSucursal(),
                        updateStock.idProducto(),
                        updateStock.nuevoStock()
                ))
                .map(productoMapper::toResponseUpdate)
                .flatMap(responseUpdate -> ServerResponse.ok().bodyValue(responseUpdate));
    }

    public Mono<ServerResponse> deleteProducto(ServerRequest request){
        return request.bodyToMono(DeleteProductoRequestDto.class)
                .flatMap(deleteProducto -> productoUseCase.deleteProducto(
                        deleteProducto.idFranquicia(),
                        deleteProducto.idSucursal(),
                        deleteProducto.idProducto()
                ))
                .then(Mono.just(new DeleteProductoResponseDto("Producto eliminado correctamente")))
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }

}
