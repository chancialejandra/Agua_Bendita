package co.com.poli.pdf.aguabendita.controllers;

import co.com.poli.pdf.aguabendita.dto.request.TipoBebidaRequest;
import co.com.poli.pdf.aguabendita.persistence.entitys.TipoBebida;
import co.com.poli.pdf.aguabendita.services.TipoBebidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/tipobebida")
@RequiredArgsConstructor
public class TipoBebidaController {

    private final TipoBebidaService tipoBebidaService;

    @PostMapping("/new")
    public ResponseEntity saveTipoBebida(@Valid @RequestBody TipoBebidaRequest tipoBebida){
        var response = tipoBebidaService.saveTipoBedida(tipoBebida);
        return ResponseEntity.status(response.status).body(response);
    }

    @GetMapping("/list")
    public List<TipoBebida> findAll(){
        return tipoBebidaService.findAll();
    }

    @DeleteMapping("/delete/{idTipoBebida}")
    public ResponseEntity deleteTipoBebida(@Valid @PathVariable Integer idTipoBebida ){
        var response = tipoBebidaService.deleteTipoBebida(idTipoBebida);
        return ResponseEntity.status(response.status).body(response);
    }

    @PutMapping("/update")
    public ResponseEntity updateTipoBebida(@Valid @RequestBody TipoBebidaRequest tipoBebida){
        var response = tipoBebidaService.updateTipoBebida(tipoBebida);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }




}
