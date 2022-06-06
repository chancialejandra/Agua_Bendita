package co.com.poli.pdf.aguabendita.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "FAC_DETALLE" )
public class FacturaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_DETALLE")
    private int idDetalle;
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Column(name = "DESCUENTO")
    private Number descuento;
}
