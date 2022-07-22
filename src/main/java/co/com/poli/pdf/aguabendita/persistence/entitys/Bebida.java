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
@Table(name = "bebida" )
public class Bebida {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_bebida")
    private int idBebida;

    private String descripcion;

    private Number precio;

    private Integer inventario;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_tipo")
    private TipoBebida tipoBebida;

    @OneToMany(mappedBy = "bebida",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private List<FacturaDetalle> facturaDetalle;


}
