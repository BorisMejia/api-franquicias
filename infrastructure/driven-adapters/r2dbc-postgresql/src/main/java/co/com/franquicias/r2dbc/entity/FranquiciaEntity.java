package co.com.franquicias.r2dbc.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
