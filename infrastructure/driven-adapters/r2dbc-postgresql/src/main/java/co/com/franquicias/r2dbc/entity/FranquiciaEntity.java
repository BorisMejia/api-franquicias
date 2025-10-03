package co.com.franquicias.r2dbc.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

import java.util.List;

@Table(name = "franquicia")
@Data
public class FranquiciaEntity {

    @Id
    private String idFranquicia;

    private String nombreFranquicia;

    private List<SucursalEntity> listaSucursales;
}
