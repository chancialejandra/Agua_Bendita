package co.com.poli.pdf.aguabendita.persistence.entitys;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "fac_detalle" )
public class FacturaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_detalle")
    private int idDetalle;

    private int cantidad;

    private Number total;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_promocion")
    private Promocion promocion;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_bebida")
    private Bebida bebida;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_encabezado")
    private FacturaEncabezado facturaEncabezado;
}
