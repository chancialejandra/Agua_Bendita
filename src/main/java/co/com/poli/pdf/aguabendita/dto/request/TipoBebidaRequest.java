package co.com.poli.pdf.aguabendita.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TipoBebidaRequest {

    @NotNull(message = "El id no puede estar vacio")
    private Integer id_tipo;


   @NotEmpty(message = "La descripcion no puede estar vacia")
    private String descripcion;
}
