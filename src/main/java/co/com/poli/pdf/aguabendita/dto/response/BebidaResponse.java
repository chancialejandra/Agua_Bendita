package co.com.poli.pdf.aguabendita.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BebidaResponse {

    private String message;
    private Integer id_bebida;
    private String descripcion;
    private Number precio;
    private Integer inventario;
    private TipoBebidaResponse tipo_bebida;
}
