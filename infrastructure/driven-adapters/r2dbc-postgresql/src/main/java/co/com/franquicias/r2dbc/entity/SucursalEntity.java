package co.com.franquicias.r2dbc.entity;

import co.com.franquicias.model.producto.Producto;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Table(name = "sucursal")
@Data
public class SucursalEntity {

    @Id
    private Integer idSucursal;
    private String nombreSucursal;
    private List<Producto> listaProductos;
}
