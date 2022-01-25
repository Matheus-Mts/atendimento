package com.atendimento.controllers;


import com.atendimento.models.Cliente;
import com.atendimento.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> retornarCliente(@PathVariable Long id) {
        return clienteService.retornarCliente(id)
                .map(cliente -> ResponseEntity.status(HttpStatus.OK).body(cliente))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
