package com.atendimento.services;

import com.atendimento.models.Ca;
import com.atendimento.models.Cliente;
import com.atendimento.repository.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;
    
    @Mock
    private Ca ca;

    private Cliente cliente;

    private Optional<Cliente> clienteOptional;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente = new Cliente(1L,ca,"teste","teste","teste",1L);
        clienteOptional = Optional.of(cliente);
    }

    @Test
    void getRepositoryGenerico() {
        Assertions.assertNotNull(clienteService.getRepositoryGenerico());
    }

    @Test
    void retornarCliente() {
        Mockito.doReturn(clienteOptional).when(clienteRepository).findById(Mockito.anyLong());
        Optional<Cliente> response = clienteService.retornarCliente(1L);
        Assertions.assertEquals(cliente,response.get());
    }
}