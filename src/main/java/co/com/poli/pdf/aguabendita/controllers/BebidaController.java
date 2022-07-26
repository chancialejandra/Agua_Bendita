package co.com.poli.pdf.aguabendita.controllers;

import co.com.poli.pdf.aguabendita.dto.request.BebidaRequest;
import co.com.poli.pdf.aguabendita.persistence.entitys.Bebida;
import co.com.poli.pdf.aguabendita.services.BebidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/bebida")
@RequiredArgsConstructor
public class BebidaController {

    private final BebidaService bebidaService;

    @PostMapping("/new")
    public ResponseEntity saveBebida(@Valid @RequestBody BebidaRequest bebida){
        var response = bebidaService.saveBedida(bebida);
        return ResponseEntity.status(response.status).body(response);
    }

    @GetMapping("/list")
    public List<Bebida> findAll(){
        return bebidaService.findAll();
    }

    @DeleteMapping("/delete/{idBebida}")
    public ResponseEntity deleteBebida(@Valid @PathVariable Integer idBebida ){
        var response = bebidaService.deleteBebida(idBebida);
        return ResponseEntity.status(response.status).body(response);
    }

    @PutMapping("/update")
    public ResponseEntity updateBebida(@Valid @RequestBody BebidaRequest bebida){
        var response = bebidaService.updateBebida(bebida);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
