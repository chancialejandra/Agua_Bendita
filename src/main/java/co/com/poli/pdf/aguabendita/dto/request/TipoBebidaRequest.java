package co.com.poli.pdf.aguabendita.dto.request;

import lombok.Data;


@Data
public class TipoBebidaRequest {

    private Integer id_tipo;

//    @NotBlank(message = "El campo no puede estar vacio")
    private String descripcion;
}
