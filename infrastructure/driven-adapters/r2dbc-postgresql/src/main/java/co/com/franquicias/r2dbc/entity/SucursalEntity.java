package co.com.franquicias.r2dbc.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

import java.util.List;

@Table(name = "sucursal")
@Data
public class SucursalEntity {

    @Id
    private Integer idSucursal;
    private String nombreSucursal;
    private List<ProductoEntity> listaProductos;
}
