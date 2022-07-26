package co.com.poli.pdf.aguabendita.services;

import co.com.poli.pdf.aguabendita.dto.request.BebidaRequest;
import co.com.poli.pdf.aguabendita.dto.request.TipoBebidaRequest;
import co.com.poli.pdf.aguabendita.dto.response.BebidaResponse;
import co.com.poli.pdf.aguabendita.dto.response.MessageResponse;
import co.com.poli.pdf.aguabendita.dto.response.TipoBebidaResponse;
import co.com.poli.pdf.aguabendita.persistence.entitys.Bebida;
import co.com.poli.pdf.aguabendita.persistence.entitys.TipoBebida;
import co.com.poli.pdf.aguabendita.persistence.repositorys.IBebidaRepository;
import co.com.poli.pdf.aguabendita.persistence.repositorys.ITipoBebidaRepository;
import co.com.poli.pdf.aguabendita.services.interfaces.IBebidaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BebidaService implements IBebidaService {

    @Autowired
    IBebidaRepository bebidaRepository;
    @Autowired
    TipoBebidaService tipoBebidaService;

    ModelMapper mapper = new ModelMapper();
    @Override
    public Boolean existBebida(Integer idBebida) {
        return bebidaRepository.existsById(idBebida);
    }

    @Override
    public List<Bebida> findAll() {
        return bebidaRepository.findAll();
    }

    @Override
    public MessageResponse deleteBebida(Integer idBebida) {

        MessageResponse responseMessage = null;

        try {
            if(!existBebida(idBebida)){
                return MessageResponse.builder()
                        .message("La bebida no existe")
                        .status(HttpStatus.BAD_REQUEST)
                        .build();
            }else {

                bebidaRepository.deleteById(idBebida);
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
    public BebidaResponse updateBebida(BebidaRequest bebidaRequest) {

        Bebida bebida = mapper.map(bebidaRequest,Bebida.class);
        BebidaResponse responseBebida = null;

        try {
            if(existBebida(bebida.getIdBebida())){
                var response = bebidaRepository.save(bebida);
                return  responseBebida.builder()
                        .message("Tipo de bebida actualizado correctamente")
//                        .id_tipo(response.getIdTipo())
                        .descripcion(response.getDescripcion())
                        .build();
            }else {
                return  responseBebida.builder()
                        .message("Tipo de bebida no existe")
//                        .id_tipo(tipoBebida.getIdTipo())
//                        .descripcion(tipoBebida.getDescripcion())
                        .build();
            }
        }catch(Exception ex){
            System.out.println("Error guardando");
        }
        return responseBebida;
    }

    @Override
    public MessageResponse saveBedida(BebidaRequest bebidaRequest) {

        Bebida bebida = mapper.map(bebidaRequest,Bebida.class);
        MessageResponse responseMessage = null;

        try {
            if(existBebida(bebida.getIdBebida())){
                if(!tipoBebidaService.existTipoBebida(bebida.getTipoBebida().getIdTipo())){
                    return MessageResponse.builder()
                            .message("El tipo de bebida no existe")
                            .status(HttpStatus.BAD_REQUEST)
                            .build();
                }

                return MessageResponse.builder()
                        .message("El tipo de bebida ya existe")
                        .status(HttpStatus.BAD_REQUEST)
                        .build();
            }else {
                var response = bebidaRepository.save(bebida);
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
