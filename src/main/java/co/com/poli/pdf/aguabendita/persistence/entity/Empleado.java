package co.com.poli.pdf.aguabendita.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "EMPLEADO" )
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_EMPLEADO")
    private int idEmpleado;
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Column(name = "DOCUMENTO")
    private String documento;
    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;
    @Column(name = "SALARIO")
    private Number salario;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "FECHA_INGRESO")
    private Date fechaIngreso;
    @Column(name = "FECHA_SALIDA")
    private Date fechaSalida;
}
