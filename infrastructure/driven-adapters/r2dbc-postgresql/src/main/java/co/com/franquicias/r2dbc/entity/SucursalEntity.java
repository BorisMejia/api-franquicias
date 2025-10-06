package co.com.franquicias.r2dbc.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Table(name = "sucursal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SucursalEntity {

    @Id
    @Column("id_sucursal")
    private Integer idSucursal;
    
    @Column("nombre_sucursal")
    private String nombreSucursal;
    
    @Column("id_franquicia")
    private Integer idFranquicia;
}
