package com.atendimento.services;

import com.atendimento.models.Cliente;
import com.atendimento.repository.ClienteRepository;
import com.atendimento.repository.RepositoryGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService extends ServiceGenericoImpl<Cliente,Long> {


    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    protected RepositoryGenerico<Cliente, Long> getRepositoryGenerico() {
        return clienteRepository;
    }

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Optional<Cliente> retornarCliente(Long id) {
        return clienteRepository.findById(id);
    }


}
