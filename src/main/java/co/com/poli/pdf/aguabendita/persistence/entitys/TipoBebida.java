package co.com.poli.pdf.aguabendita.persistence.entitys;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "tipo_bebida" )
public class TipoBebida {

    @Id
    @Column(name = "id_tipo")
    private int idTipo;

    private String descripcion;

    @OneToMany(mappedBy = "tipoBebida", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Bebida> bebida;

}
