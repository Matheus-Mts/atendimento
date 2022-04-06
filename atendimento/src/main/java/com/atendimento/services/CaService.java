package com.atendimento.services;

import com.atendimento.models.Ca;
import com.atendimento.repository.CaRepository;
import com.atendimento.repository.RepositoryGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CaService extends ServiceGenericoImpl<Ca,Long> {

    @Override
    protected RepositoryGenerico<Ca, Long> getRepositoryGenerico() {
        return caRepository;
    }

    @Autowired
    private CaRepository caRepository;

    public CaService(CaRepository caRepository) {
        this.caRepository = caRepository;
    }

    public Optional<Ca> retornarCa(Long id) {
        return caRepository.findById(id);
    }

}
