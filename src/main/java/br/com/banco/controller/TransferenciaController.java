package br.com.banco.controller;

import br.com.banco.model.filtros.FiltroTransferencia;
import br.com.banco.service.interfaces.TransferenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/transferencia")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @GetMapping(value = "/{id}/conta")
    public ResponseEntity findByConta(@PathVariable("id") Long idConta) {
        return ResponseEntity.ok(transferenciaService.findByConta(idConta));
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(transferenciaService.findAll());
    }

    @PostMapping(value = "/search")
    public ResponseEntity search(@RequestBody FiltroTransferencia filtros) {
        return ResponseEntity.ok(transferenciaService.search(filtros));
    }

}
