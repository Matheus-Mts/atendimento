package com.atendimento.controllers;


import com.atendimento.models.Cliente;
import com.atendimento.services.ClienteService;
import com.atendimento.services.ServiceGenericoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/cliente")
public class ClienteController extends ControllerGenerico<Cliente,Long> {

    @Autowired
    private ClienteService clienteService;

    @Override
    protected ServiceGenericoImpl<Cliente, Long> getServiceGenerico() {
        return clienteService;
    }

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


}
