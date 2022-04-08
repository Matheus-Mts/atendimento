package com.atendimento.services;

import com.atendimento.models.*;
import com.atendimento.models.dto.UsuarioDTO;
import com.atendimento.repository.AtendimentoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



class AtendimentoServiceTest {

    @InjectMocks
    private AtendimentoService atendimentoService;

    @Mock
    private AtendimentoRepository atendimentoRepository;

    private Atendimento atendimento;

    private Optional<Atendimento> atendimentoOptional;

    private List<Atendimento> atendimentos;

    @Mock
    private Ca ca;

    @Mock
    private Cliente cliente;

    @Mock
    private Modulo modulo;

    @Mock
    private Assunto assunto;

    @Mock
    private UsuarioDTO usuarioDTO;

    @Mock
    private Sugestao sugestao;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        atendimento = new Atendimento(1L,ca,cliente,modulo,"teste",null,true,"teste",
                true,assunto,"teste","10:00",false,"teste",sugestao,usuarioDTO);
        atendimentoOptional = Optional.of(atendimento);
        atendimentos = new ArrayList<>();
        atendimentos.add(atendimento);

    }

    @Test
    void getRepositoryGenerico() {
        Assertions.assertNotNull(atendimentoService.getRepositoryGenerico());
    }

    @Test
    void salvarAtendimento() {
        Mockito.doReturn(atendimento).when(atendimentoRepository).save(atendimento);
        Atendimento response = atendimentoService.salvar(atendimento);
        Assertions.assertNotNull(response);
    }

    @Test
    void retornarTodosAtendimentos() {
        Mockito.doReturn(atendimentos).when(atendimentoRepository).findAll();
        atendimentos = atendimentoService.retornarTodosAtendimentos().get();
        Assertions.assertNotNull(atendimentos);
    }

    @Test
    void retornarAtendimentoPorID() {
        Mockito.doReturn(atendimentoOptional).when(atendimentoRepository).findById(Mockito.anyLong());
        atendimentoOptional = atendimentoService.retornarAtendimentoPorID(1L);
        Assertions.assertNotNull(atendimentoOptional.get());

    }
}