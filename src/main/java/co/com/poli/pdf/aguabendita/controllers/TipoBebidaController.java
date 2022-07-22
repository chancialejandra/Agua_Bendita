package co.com.poli.pdf.aguabendita.controllers;

import co.com.poli.pdf.aguabendita.dto.request.TipoBebidaRequest;
import co.com.poli.pdf.aguabendita.services.TipoBebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/tipobebida")
public class TipoBebidaController {

    @Autowired
    TipoBebidaService tipoBebidaService;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevoTipoBebida(@RequestBody TipoBebidaRequest tipoBebidaRequest){
        return ResponseEntity.ok(tipoBebidaService.nuevoTipoBedida(tipoBebidaRequest));

    }


}
