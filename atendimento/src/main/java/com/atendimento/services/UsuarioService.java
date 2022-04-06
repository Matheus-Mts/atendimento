package com.atendimento.services;

import com.atendimento.models.dto.UsuarioDTO;
import com.atendimento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class UsuarioService extends ServiceGenericoImpl {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<UsuarioDTO> salvarUsuarioDaFila(UsuarioDTO usuarioDTO) {
        return Optional.of(this.usuarioRepository.save(usuarioDTO));
    }

    public void excluirUsuarioDaFila(long id) {
        this.usuarioRepository.delete(usuarioRepository.findById(id).get());
    }

    public void alterarUsuarioDaFila(UsuarioDTO usuarioDTO) {
        if (this.usuarioRepository.findById(usuarioDTO.getId()).isPresent()) {
            this.usuarioRepository.save(usuarioDTO);
        }
    }
}
