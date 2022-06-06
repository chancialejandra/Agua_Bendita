package co.com.poli.pdf.aguabendita.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "CAMPANA" )
public class Campana {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name = "ID_CAMPANA")
 private int idCampana;
 @Column(name = "FECHA_CAMPANA")
 private Date fechaCampana;
 @Column(name = "DESCUENTO")
 private Number descuento;

}
