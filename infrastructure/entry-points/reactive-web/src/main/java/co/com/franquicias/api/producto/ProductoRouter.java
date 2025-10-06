package co.com.franquicias.api.producto;

import co.com.franquicias.api.producto.dto.request.DeleteProductoRequestDto;
import co.com.franquicias.api.producto.dto.request.RegisterProductoRequestDto;
import co.com.franquicias.api.producto.dto.request.UpdateNombreProductoRequestDto;
import co.com.franquicias.api.producto.dto.request.UpdateStockProductoRequestDto;
import co.com.franquicias.api.producto.dto.response.DeleteProductoResponseDto;
import co.com.franquicias.api.producto.dto.response.RegisterProductoResponseDto;
import co.com.franquicias.api.producto.dto.response.UpdateNombreProductoResponseDto;
import co.com.franquicias.api.producto.dto.response.UpdateStockProductoResponseDto;
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

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
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
            ),
            @RouterOperation(
                    path = "/franquicia/sucursal/producto/update-stock",
                    method = RequestMethod.PATCH,
                    beanClass = ProductoHandler.class,
                    beanMethod = "updateStock",
                    operation = @Operation(
                            operationId = "updateStock",
                            summary = "Actualizar el stock de un producto",
                            description = "Endpoint para actualizar el stock de un producto por id",
                            tags = {"Productos"},
                            requestBody = @RequestBody(
                                    description = "Datos del producto a actualizar",
                                    required = true,
                                    content = @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = UpdateStockProductoRequestDto.class)
                                    )
                            ),
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Stock del producto actualizado correctamente",
                                            content = @Content(
                                                    mediaType = "application/json",
                                                    schema = @Schema(implementation = UpdateStockProductoResponseDto.class)
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
            ),
            @RouterOperation(
                    path = "/franquicia/sucursal/producto/delete",
                    method = RequestMethod.DELETE,
                    beanClass = ProductoHandler.class,
                    beanMethod = "deleteProducto",
                    operation = @Operation(
                            operationId = "deleteProducto",
                            summary = "Eliminar un producto",
                            description = "Endpoint para eliminar un producto por id",
                            tags = {"Productos"},
                            requestBody = @RequestBody(
                                    description = "Datos del producto a eliminar",
                                    required = true,
                                    content = @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = DeleteProductoRequestDto.class)
                                    )
                            ),
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Producto eliminado correctamente",
                                            content = @Content(
                                                    mediaType = "application/json",
                                                    schema = @Schema(implementation = DeleteProductoResponseDto.class)
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
            ),
            @RouterOperation(
                    path = "/franquicia/sucursal/producto/update-nombre-producto",
                    method = RequestMethod.PATCH,
                    beanClass = ProductoHandler.class,
                    beanMethod = "updateNombreProducto",
                    operation = @Operation(
                            operationId = "updateNombreProducto",
                            summary = "Actualizar el nombre de un producto",
                            description = "Endpoint para actualizar el nombre de un producto por id",
                            tags = {"Productos"},
                            requestBody = @RequestBody(
                                    description = "Datos del producto a actualizar",
                                    required = true,
                                    content = @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = UpdateNombreProductoRequestDto.class)
                                    )
                            ),
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Nombre del producto actualizado correctamente",
                                            content = @Content(
                                                    mediaType = "application/json",
                                                    schema = @Schema(implementation = UpdateNombreProductoResponseDto.class)
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
                .andRoute(PATCH("/franquicia/sucursal/producto/update-stock"), productoHandler::updateStock)
                .andRoute(DELETE("/franquicia/sucursal/producto/delete"), productoHandler::deleteProducto)
                .andRoute(PATCH("/franquicia/sucursal/producto/update-nombre-producto"), productoHandler::updateNombreProducto)
                ;
    }

}
