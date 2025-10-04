package co.com.franquicias.api.sucursal;

import co.com.franquicias.api.sucursal.dto.request.RegisterSucursalRequestDto;
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

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class SucursalRouter {

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/franquicia/sucursal/create",
                    method = RequestMethod.POST,
                    beanClass = SucursalHandler.class,
                    beanMethod = "createSucursal",
                    operation = @Operation(
                            operationId = "createSucursal",
                            summary = "Crear una sucursal para una franquicia",
                            description = "Endpoint para crear una sucursal para una franquicia",
                            tags = {"Sucursales"},
                            requestBody = @RequestBody(
                                    description = "Datos de la sucursal a crear",
                                    required = true,
                                    content = @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = RegisterSucursalRequestDto.class)
                                    )
                            ),
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Sucursal agregada correctamente",
                                            content = @Content(
                                                    mediaType = "application/json",
                                                    schema = @Schema(implementation = SucursalResponseDto.class)
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
    public RouterFunction<ServerResponse> routerSucursal(SucursalHandler sucursalHandler){
        return route(POST("/franquicia/sucursal/create"), sucursalHandler::createSucursal)

                ;
    }

}
