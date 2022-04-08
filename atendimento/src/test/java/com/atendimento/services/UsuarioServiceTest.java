package com.atendimento.services;

import com.atendimento.models.Atendimento;
import com.atendimento.models.dto.UsuarioDTO;
import com.atendimento.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    private UsuarioDTO usuarioDTO;

    private Optional<UsuarioDTO> usuarioDTOOptional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        usuarioDTO = new UsuarioDTO(1L,"teste@teste","0321");
        usuarioDTOOptional = Optional.of(usuarioDTO);

    }

    @Test
    void salvarUsuarioDaFila() {
        Mockito.doReturn(usuarioDTO).when(usuarioRepository).save(usuarioDTO);
        Optional<UsuarioDTO> response = usuarioService.salvarUsuarioDaFila(usuarioDTO);
        Assertions.assertNotNull(response.get());
    }

    @Test
    void excluirUsuarioDaFila() {
        Mockito.doReturn(usuarioDTOOptional).when(usuarioRepository).findById(Mockito.anyLong());
        Mockito.doNothing().when(usuarioRepository).delete(usuarioDTO);
        usuarioService.excluirUsuarioDaFila(1L);
    }

    @Test
    void alterarUsuarioDaFila() {
        Mockito.doReturn(usuarioDTOOptional).when(usuarioRepository).findById(Mockito.anyLong());
        usuarioDTOOptional.get().setSenha("123");
        Mockito.doReturn(usuarioDTOOptional.get()).when(usuarioRepository).save(usuarioDTOOptional.get());
        Optional<UsuarioDTO> response = usuarioService.alterarUsuarioDaFila(usuarioDTOOptional.get());
        
    }
}