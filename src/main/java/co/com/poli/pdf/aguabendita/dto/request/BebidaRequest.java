package co.com.poli.pdf.aguabendita.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BebidaRequest {

    @NotNull(message = "El id no puede estar vacio")
    private Integer id_bebida;

    @NotEmpty(message = "La descripcion no puede estar vacia")
    private String descripcion;

    private Integer inventario;

    @NotNull(message = "El precio no puede estar vacio")
    private Integer precio;

    @NotNull(message = "El tipo de bebida no puede estar vacio")
    @Valid
    private TipoBebidaRequest tipo_bebida;
}
