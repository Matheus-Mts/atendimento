package com.atendimento.controllers;

import com.atendimento.models.Ca;
import com.atendimento.services.CaService;
import com.atendimento.services.ServiceGenericoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/ca")
public class CaController extends ControllerGenerico<Ca,Long> {

    @Autowired
    private CaService caService;

    @Override
    protected ServiceGenericoImpl<Ca, Long> getServiceGenerico() {
        return caService;
    }

    public CaController(CaService caService) {
        this.caService = caService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ca> retornarCa(@PathVariable Long id) {
        return caService.retornarCa(id)
                .map(ca -> ResponseEntity.status(HttpStatus.OK).body(ca))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


}
