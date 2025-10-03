package co.com.franquicias.r2dbc.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoEntity {

    @Id
    @Column("id_producto")
    private Integer idProducto;
    
    @Column("nombre_producto")
    private String nombreProducto;
    
    @Column("stock")
    private Integer stock;
    
    @Column("id_sucursal")
    private Integer idSucursal;
}
