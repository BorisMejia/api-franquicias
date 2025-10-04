package co.com.franquicias.api.franquicia;

import co.com.franquicias.api.franquicia.dto.request.RegisterFranquiciaDto;
import co.com.franquicias.api.franquicia.dto.request.UpdateNombreFranquiciaRequestDto;
import co.com.franquicias.api.franquicia.dto.response.FranquiciaResponseDto;
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
public class FranquiciaRouter {
    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/franquicia/register",
                    method = RequestMethod.POST,
                    beanClass = FranquiciaHandler.class,
                    beanMethod = "registerFranquicia",
                    operation = @Operation(
                            operationId = "registerFranquicia",
                            summary = "Registrar nueva franquicia",
                            description = "Endpoint para registrar una nueva franquicia en el sistema con ID único y nombre descriptivo",
                            tags = {"Franquicias"},
                            requestBody = @RequestBody(
                                    description = "Datos de la franquicia a registrar",
                                    required = true,
                                    content = @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = RegisterFranquiciaDto.class)
                                    )
                            ),
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Franquicia registrada exitosamente",
                                            content = @Content(
                                                    mediaType = "application/json",
                                                    schema = @Schema(implementation = FranquiciaResponseDto.class)
                                            )
                                    ),
                                    @ApiResponse(
                                            responseCode = "400",
                                            description = "Datos de entrada inválidos o franquicia ya existe"
                                    ),
                                    @ApiResponse(
                                            responseCode = "500",
                                            description = "Error interno del servidor"
                                    )
                            }
                    )
            ),
            @RouterOperation(
                    path = "/franquicia/update",
                    method = RequestMethod.PATCH,
                    beanClass = FranquiciaHandler.class,
                    beanMethod = "updateFranquicia",
                    operation = @Operation(
                            operationId = "updateFranquicia",
                            summary = "Actualizar el nombre de una Franquicia",
                            description = "Endpoint para actualizar el nombre de una franquicia con ID",
                            tags = {"Franquicias"},
                            requestBody = @RequestBody(
                                    description = "Datos de la franquicia a actualizar",
                                    required = true,
                                    content = @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = UpdateNombreFranquiciaRequestDto.class)
                                    )
                            ),
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Franquicia actualizada correctamente",
                                            content = @Content(
                                                    mediaType = "application/json",
                                                    schema = @Schema(implementation = FranquiciaResponseDto.class)
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
    public RouterFunction<ServerResponse> routeFranquicia (FranquiciaHandler franquiciaHandler){
        return route(POST("/franquicia/register"), franquiciaHandler::registerFranquicia)
                .andRoute(PATCH("/franquicia/update"), franquiciaHandler::updateFranquicia)

                ;
    }

}
