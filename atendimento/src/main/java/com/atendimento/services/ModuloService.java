package com.atendimento.services;

import com.atendimento.models.Modulo;
import com.atendimento.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;

    public ModuloService(ModuloRepository moduloRepository) {
        this.moduloRepository = moduloRepository;
    }

    public Optional<Modulo> retornarModuloPorId(Long id) {
        return moduloRepository.findById(id);
    }

    public Optional<Modulo> retornarModuloPorNome(String nome_modulo) {
        return moduloRepository.findBynomeModulo(nome_modulo);
    }
}
