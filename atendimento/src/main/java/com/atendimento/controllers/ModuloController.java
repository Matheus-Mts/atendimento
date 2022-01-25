package com.atendimento.controllers;

import com.atendimento.models.Modulo;
import com.atendimento.services.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/modulo")
public class ModuloController {

    @Autowired
    private ModuloService moduloService;

    public ModuloController(ModuloService moduloService) {
        this.moduloService = moduloService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Modulo> retornarModulo(@PathVariable Long id ) {
        return moduloService.retornarModuloPorId(id)
                .map(modulo -> ResponseEntity.status(HttpStatus.OK).body(modulo))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping(value = "/nome/{nome_modulo}")
    public ResponseEntity<Modulo> retornarModulo(@PathVariable String nome_modulo ) {
        return moduloService.retornarModuloPorNome(nome_modulo)
                .map(modulo -> ResponseEntity.status(HttpStatus.OK).body(modulo))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
