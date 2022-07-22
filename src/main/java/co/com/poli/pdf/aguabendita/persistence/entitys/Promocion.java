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
@Table(name = "promocion" )
public class Promocion {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name = "id_promocion")
 private int idPromocion;

 @Column(name = "fecha_promocion")
 private Date fechaPromocion;

 private Number descuento;

 @OneToMany(mappedBy = "promocion",fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
 private List<FacturaDetalle> facturaDetalle;

}
