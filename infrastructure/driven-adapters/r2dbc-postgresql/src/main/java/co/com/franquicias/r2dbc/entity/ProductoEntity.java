package co.com.franquicias.r2dbc.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "producto")
@Data
public class ProductoEntity {

    @Id
    private Integer idProducto;
    private String nombreProducto;
    private Integer stock;
}
