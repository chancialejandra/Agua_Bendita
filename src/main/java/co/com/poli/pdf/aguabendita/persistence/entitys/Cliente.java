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
@Table(name = "cliente" )
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
    private int idCliente;

    @Column(name = "primer_nombre")
    private String primerNombre;

    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @Column(name = "primer_apellido")
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    private String documento;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    private String telefono;

    @OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<FacturaEncabezado> facturaEncabezado;

}
