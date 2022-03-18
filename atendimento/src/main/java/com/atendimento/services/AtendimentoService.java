package com.atendimento.services;

import com.atendimento.models.Atendimento;
import com.atendimento.repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoService {

    @Autowired
    AtendimentoRepository atendimentoRepository;



    public AtendimentoService(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }

    public Optional<Atendimento> salvarAtendimento(Atendimento atendimento) {
        return Optional.ofNullable(atendimentoRepository.save(atendimento));
    }

    public Optional<List<Atendimento>> retornarTodosAtendimentos() {
        return Optional.ofNullable(atendimentoRepository.findAll());
    }

    public Optional<Atendimento> retornarAtendimentoPorID(long id) {
        return atendimentoRepository.findById(id);
    }
}
