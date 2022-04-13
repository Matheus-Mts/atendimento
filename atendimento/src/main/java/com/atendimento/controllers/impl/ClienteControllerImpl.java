package com.atendimento.controllers.impl;


import com.atendimento.controllers.ControllerGenerico;
import com.atendimento.models.Atendimento;
import com.atendimento.models.Cliente;
import com.atendimento.models.Modulo;
import com.atendimento.services.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteControllerImpl implements ControllerGenerico<Cliente,Long> {

    @Autowired
    private ClienteService clienteService;


    private ServiceGenericoImpl<Cliente, Long> getServiceGenerico() {
        return clienteService;
    }

    public ClienteControllerImpl(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente objeto)  {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(getServiceGenerico().salvar(objeto));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable(value = "id") Long id) {
        Optional<Cliente> possivelCliente = getServiceGenerico().buscarEntidadePorId(id);
        return (possivelCliente.isPresent()) ? ResponseEntity.status(HttpStatus.OK).body(possivelCliente.get())
                                             : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cliente> atualizarPorId(@PathVariable Long id, @RequestBody Cliente objeto) {
        try {
            return Optional.of(getServiceGenerico().atualizarPorId(id,objeto))
                    .map(cliente -> ResponseEntity.status(HttpStatus.OK).body(cliente))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        }catch (NotFoundException e) {
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
    public ResponseEntity<Page<Cliente>> pesquisar(final Pageable pageable, final @RequestParam(value = "ehPaginado", defaultValue = "false")
            Boolean ehPaginado) {
        return new ResponseEntity<>(getServiceGenerico().pesquisarPaginado(pageable,ehPaginado), HttpStatus.OK);
    }
}
