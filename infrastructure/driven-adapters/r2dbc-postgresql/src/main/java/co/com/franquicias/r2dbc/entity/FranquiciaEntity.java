package co.com.franquicias.r2dbc.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Table(name = "franquicia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FranquiciaEntity {

    @Id
    @Column("id_franquicia")
    private Integer idFranquicia;

    @Column("nombre_franquicia")
    private String nombreFranquicia;

}
