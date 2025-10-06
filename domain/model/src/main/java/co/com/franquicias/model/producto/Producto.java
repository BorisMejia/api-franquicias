package co.com.franquicias.model.producto;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Producto {
    private Integer idProducto;
    private String nombreProducto;
    private Integer stock;
    private Integer idSucursal;
}
