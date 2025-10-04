package co.com.franquicias.model.sucursal;
import co.com.franquicias.model.producto.Producto;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Sucursal {
    private Integer idSucursal;
    private String nombreSucursal;
    private Integer idFranquicia;
    private List<Producto> listaProductos;

    public Sucursal(Integer idSucursal, String nombreSucursal) {}
}
