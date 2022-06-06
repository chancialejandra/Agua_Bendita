package co.com.poli.pdf.aguabendita.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "TIPO_BEBIDA" )
public class TipoBebida {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TIPOBEBIDA")
    private int idTipoBebida;
    @Column(name = "DESCRIPCION")
    private String descripcion;
}
