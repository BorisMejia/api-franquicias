package co.com.franquicias.r2dbc.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Table(name = "producto")
@Data
public class ProductoEntity {

    @Id
    private Integer idProducto;
    private String nombreProducto;
    private Integer stock;
}
