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
@Table(name = "estado" )
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_estado")
    private int idEstado;

    private String descripcion;

    @OneToMany(mappedBy = "estado",fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Empleado> empleado;
}
