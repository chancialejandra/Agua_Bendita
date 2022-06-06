package co.com.poli.pdf.aguabendita.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "FAC_ENCABEZADO" )
public class FacturaEncabezado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ENCABEZADO")
    private int idEncabezado;
    @Column(name = "FECHA")
    private Date fecha;
}
