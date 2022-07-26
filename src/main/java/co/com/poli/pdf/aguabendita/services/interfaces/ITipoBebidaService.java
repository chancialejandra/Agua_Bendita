package co.com.poli.pdf.aguabendita.services.interfaces;

import co.com.poli.pdf.aguabendita.dto.request.TipoBebidaRequest;
import co.com.poli.pdf.aguabendita.dto.response.MessageResponse;
import co.com.poli.pdf.aguabendita.dto.response.TipoBebidaResponse;
import co.com.poli.pdf.aguabendita.persistence.entitys.TipoBebida;

import java.util.List;

public interface ITipoBebidaService {

     MessageResponse saveTipoBedida(TipoBebidaRequest tipoBebidaRequest);

     Boolean existTipoBebida(Integer idTipo);

     List<TipoBebida> findAll();

     MessageResponse deleteTipoBebida(Integer idTipo);

     TipoBebidaResponse updateTipoBebida(TipoBebidaRequest tipoBebidaRequest);


}
