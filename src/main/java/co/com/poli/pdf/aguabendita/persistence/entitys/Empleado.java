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
@Table(name = "empleado" )
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empleado")
    private int idEmpleado;

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

    private Number salario;

    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;

    @Column(name = "fecha_salida")
    private Date fechaSalida;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @OneToMany(mappedBy = "empleado",fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<FacturaEncabezado> facturaEncabezado;
}
