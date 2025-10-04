package co.com.franquicias.api.producto;

import co.com.franquicias.api.producto.dto.request.RegisterProductoRequestDto;
import co.com.franquicias.api.producto.dto.response.RegisterProductoResponseDto;
import co.com.franquicias.api.sucursal.SucursalHandler;
import co.com.franquicias.api.sucursal.dto.response.SucursalResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProductoRouter {

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/franquicia/sucursal/producto/create",
                    method = RequestMethod.POST,
                    beanClass = ProductoHandler.class,
                    beanMethod = "createProducto",
                    operation = @Operation(
                            operationId = "createProduto",
                            summary = "Crear un nuevo producto para una sucursal",
                            description = "Endpoint para crear un nuevo producto para una sucursal",
                            tags = {"Productos"},
                            requestBody = @RequestBody(
                                    description = "Datos del producto a crear",
                                    required = true,
                                    content = @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = RegisterProductoRequestDto.class)
                                    )
                            ),
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Producto agregado correctamente",
                                            content = @Content(
                                                    mediaType = "application/json",
                                                    schema = @Schema(implementation = RegisterProductoResponseDto.class)
                                            )
                                    ),
                                    @ApiResponse(
                                            responseCode = "400",
                                            description = "Datos de entrada inválidos"
                                    ),
                                    @ApiResponse(
                                            responseCode = "500",
                                            description = "Error interno del servidor"
                                    )
                            }
                    )
            )

    })
    public RouterFunction<ServerResponse> routerProducto(ProductoHandler productoHandler){
        return route(POST("/franquicia/sucursal/producto/create"), productoHandler::createProducto)

                ;
    }

}
