package co.com.poli.pdf.aguabendita.services.interfaces;

import co.com.poli.pdf.aguabendita.dto.request.BebidaRequest;
import co.com.poli.pdf.aguabendita.dto.request.TipoBebidaRequest;
import co.com.poli.pdf.aguabendita.dto.response.BebidaResponse;
import co.com.poli.pdf.aguabendita.dto.response.MessageResponse;
import co.com.poli.pdf.aguabendita.dto.response.TipoBebidaResponse;
import co.com.poli.pdf.aguabendita.persistence.entitys.Bebida;
import co.com.poli.pdf.aguabendita.persistence.entitys.TipoBebida;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBebidaService {

    MessageResponse saveBedida(BebidaRequest bebidaRequest);

    Boolean existBebida(Integer idTipo);

    List<Bebida> findAll();

    MessageResponse deleteBebida(Integer idTipo);

    BebidaResponse updateBebida(BebidaRequest bebidaRequest);
}
