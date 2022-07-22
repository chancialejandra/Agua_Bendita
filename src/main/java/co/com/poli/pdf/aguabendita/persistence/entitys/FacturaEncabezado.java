package co.com.poli.pdf.aguabendita.persistence.entitys;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "fac_encabezado" )
public class FacturaEncabezado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_encabezado")
    private int idEncabezado;

    private Date fecha;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @OneToMany(mappedBy = "facturaEncabezado",fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<FacturaDetalle> facturaDetalle;
}
