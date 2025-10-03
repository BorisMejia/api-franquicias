package co.com.franquicias.model.franquicia;
import co.com.franquicias.model.sucursal.Sucursal;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Franquicia {
    private Integer idFranquicia;
    private String nombreFranquicia;
    private List<Sucursal> listaSucursales;

    public Franquicia(Integer idFranquicia, String nombreFranquicia) {
    }
}
