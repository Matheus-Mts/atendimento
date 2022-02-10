package com.atendimento.services;

import com.atendimento.models.Atendimento;
import com.atendimento.models.Usuario;
import com.atendimento.repository.AtendimentoRepository;
import com.atendimento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoService {

    @Autowired
    AtendimentoRepository atendimentoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public AtendimentoService(AtendimentoRepository atendimentoRepository, UsuarioRepository usuarioRepository) {
        this.atendimentoRepository = atendimentoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<List<Atendimento>> retornaListaAtendimentoUsuario(long idUsuario) {
       return Optional.ofNullable(atendimentoRepository.findByUsuario(usuarioRepository.findById(idUsuario).get()));
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
