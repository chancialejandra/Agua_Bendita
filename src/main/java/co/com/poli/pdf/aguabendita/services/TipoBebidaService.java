package co.com.poli.pdf.aguabendita.services;

import co.com.poli.pdf.aguabendita.dto.request.TipoBebidaRequest;
import co.com.poli.pdf.aguabendita.dto.response.MessageResponse;
import co.com.poli.pdf.aguabendita.dto.response.TipoBebidaResponse;
import co.com.poli.pdf.aguabendita.persistence.entitys.TipoBebida;
import co.com.poli.pdf.aguabendita.persistence.repositorys.ITipoBebidaRepository;
import co.com.poli.pdf.aguabendita.services.interfaces.ITipoBebidaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoBebidaService implements ITipoBebidaService {

    @Autowired
    ITipoBebidaRepository tipoBebidaRepository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public Boolean existTipoBebida(Integer idTipo) {
        return tipoBebidaRepository.existsById(idTipo);
    }

    @Override
    public List<TipoBebida> findAll() {
        return tipoBebidaRepository.findAll();
    }

    @Override
    public MessageResponse deleteTipoBebida(Integer idTipo) {

        MessageResponse responseMessage = null;

        try {

            if(!existTipoBebida(idTipo)){
                return MessageResponse.builder()
                        .message("El tipo de bebida no existe")
                        .status(HttpStatus.BAD_REQUEST)
                        .build();
            }else {

                tipoBebidaRepository.deleteById(idTipo);
                responseMessage = MessageResponse.builder()
                        .message("Eliminado con exito")
                        .status(HttpStatus.OK)
                        .build();
                return responseMessage;
            }
        }catch(Exception ex){
            System.out.println("Error eliminando");
        }
        return responseMessage;
    }

    @Override
    public TipoBebidaResponse updateTipoBebida(TipoBebidaRequest tipoBebidaRequest) {

        TipoBebida tipoBebida = mapper.map(tipoBebidaRequest,TipoBebida.class);
        TipoBebidaResponse responseTipoBebida = null;

        try {
            if(existTipoBebida(tipoBebida.getIdTipo())){
                var response = tipoBebidaRepository.save(tipoBebida);
                return  responseTipoBebida.builder()
                        .message("Tipo de bebida actualizado correctamente")
                        .id_tipo(response.getIdTipo())
                        .descripcion(response.getDescripcion())
                        .build();
            }else {
                return  responseTipoBebida.builder()
                        .message("Tipo de bebida no existe")
                        .id_tipo(tipoBebida.getIdTipo())
                        .descripcion(tipoBebida.getDescripcion())
                        .build();
            }
        }catch(Exception ex){
            System.out.println("Error guardando");
        }
        return responseTipoBebida;
    }

    @Override
    public MessageResponse saveTipoBedida(TipoBebidaRequest tipoBebidaRequest) {

        TipoBebida tipoBebida = mapper.map(tipoBebidaRequest,TipoBebida.class);
        MessageResponse responseMessage = null;

        try {

            if(existTipoBebida(tipoBebida.getIdTipo())){
                return MessageResponse.builder()
                        .message("El tipo de bebida ya existe")
                        .status(HttpStatus.BAD_REQUEST)
                        .build();
            }else {

                var response = tipoBebidaRepository.save(tipoBebida);
                responseMessage = MessageResponse.builder()
                        .message("Registro con exito")
                        .status(HttpStatus.OK)
                        .build();
                return responseMessage;
            }
        }catch(Exception ex){
            System.out.println("Error guardando");
        }
        return responseMessage;
    }
}
