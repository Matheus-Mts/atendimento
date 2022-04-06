package com.atendimento.services;

import com.atendimento.models.Modulo;
import com.atendimento.repository.ModuloRepository;
import com.atendimento.repository.RepositoryGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModuloService extends ServiceGenericoImpl<Modulo,Long> {

    @Autowired
    private ModuloRepository moduloRepository;

    @Override
    protected RepositoryGenerico<Modulo, Long> getRepositoryGenerico() {
        return moduloRepository;
    }

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
