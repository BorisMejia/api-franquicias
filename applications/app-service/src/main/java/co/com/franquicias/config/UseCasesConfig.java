package co.com.franquicias.config;

import co.com.franquicias.model.franquicia.Franquicia;
import co.com.franquicias.model.franquicia.gateways.FranquiciaRepository;
import co.com.franquicias.model.producto.gateways.ProductoRepository;
import co.com.franquicias.model.sucursal.gateways.SucursalRepository;
import co.com.franquicias.usecase.franquicia.FranquiciaUseCase;
import co.com.franquicias.usecase.producto.ProductoUseCase;
import co.com.franquicias.usecase.sucursal.SucursalUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.franquicias.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {

        @Bean
        public FranquiciaUseCase franquiciaUseCase(
                FranquiciaRepository franquiciaRepositor
        ){
                return new FranquiciaUseCase(franquiciaRepositor);
        }
        @Bean
        public SucursalUseCase sucursalUseCase(
                FranquiciaRepository franquiciaRepository,
                SucursalRepository sucursalRepository
        ){
                return new SucursalUseCase(franquiciaRepository, sucursalRepository);
        }
        @Bean
        public ProductoUseCase productoUseCase(
                FranquiciaRepository franquiciaRepository,
                ProductoRepository productoRepository
        ){
                return new ProductoUseCase(franquiciaRepository, productoRepository);
        }
}
