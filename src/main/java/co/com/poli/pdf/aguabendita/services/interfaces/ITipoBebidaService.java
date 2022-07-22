package co.com.poli.pdf.aguabendita.services.interfaces;

import co.com.poli.pdf.aguabendita.dto.request.TipoBebidaRequest;
import co.com.poli.pdf.aguabendita.dto.response.MessageResponse;

public interface ITipoBebidaService {

     MessageResponse nuevoTipoBedida(TipoBebidaRequest tipoBebidaRequest);
}
