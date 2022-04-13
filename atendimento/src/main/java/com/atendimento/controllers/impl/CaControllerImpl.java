package com.atendimento.controllers.impl;

import com.atendimento.controllers.ControllerGenerico;
import com.atendimento.models.Ca;
import com.atendimento.services.CaService;
import com.atendimento.services.ServiceGenericoImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/ca")
public class CaControllerImpl implements ControllerGenerico<Ca,Long> {

    @Autowired
    private CaService caService;

    public ServiceGenericoImpl<Ca, Long> getServiceGenerico() {
        return caService;
    }

    public CaControllerImpl(CaService caService) {
        this.caService = caService;
    }

    @PostMapping
    public ResponseEntity<Ca> salvar(@RequestBody Ca objeto) {
        try {
            Optional<Ca> possivelCa = Optional.ofNullable(getServiceGenerico().salvar(objeto));
            return (possivelCa.isPresent()) ?  ResponseEntity.status(HttpStatus.CREATED).body(possivelCa.get()) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ca> buscarPorId(@PathVariable(value = "id") Long id) {
        Optional<Ca> possivelCa = getServiceGenerico().buscarEntidadePorId(id);
        return  (possivelCa.isPresent()) ?  ResponseEntity.status(HttpStatus.OK).body(possivelCa.get()) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();



    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Ca> atualizarPorId(@PathVariable Long id, @RequestBody Ca objeto)  {
        try {
            return Optional.of(getServiceGenerico().atualizarPorId(id,objeto))
                    .map(ca -> ResponseEntity.status(HttpStatus.OK).body(ca))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deletarPorId(@PathVariable  Long id) {
        if (getServiceGenerico().delete(id)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<Ca>> pesquisar(final Pageable pageable, final @RequestParam(value = "ehPaginado", defaultValue = "false")
            Boolean ehPaginado) {
        return new ResponseEntity<>(getServiceGenerico().pesquisarPaginado(pageable,ehPaginado), HttpStatus.OK);
    }
}
