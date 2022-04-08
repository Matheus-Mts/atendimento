package com.atendimento.controllers;

import com.atendimento.models.*;
import com.atendimento.models.dto.UsuarioDTO;
import com.atendimento.repository.AtendimentoRepository;
import com.atendimento.services.AtendimentoService;
import com.atendimento.services.ServiceGenericoImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
class AtendimentoControllerTest {

    @InjectMocks
    private AtendimentoController atendimentoController;

    Atendimento atendimento;

    Optional<Atendimento> atendimentoOptional;

    List<Atendimento> atendimentoList;

    @MockBean
    private AtendimentoService atendimentoService;

    @MockBean
    private AtendimentoRepository atendimentoRepository;

    @MockBean
    private Ca ca;

    @MockBean
    private Cliente cliente;

    @MockBean
    private Modulo modulo;

    @MockBean
    private Assunto assunto;

    @MockBean
    private UsuarioDTO usuarioDTO;

    @MockBean
    private Sugestao sugestao;


    @Autowired
    MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    void setUp() {
        atendimentoRepository = Mockito.mock(AtendimentoRepository.class);
        atendimentoService = Mockito.mock(AtendimentoService.class);
        atendimentoController = new AtendimentoController(atendimentoService);
        atendimento = new Atendimento(1L,ca,cliente,modulo,"teste",null,true,"teste",
                true,assunto,"teste","10:00",false,"teste",sugestao,usuarioDTO);
    }

    @Test
    void testGetServiceGenerico() {
        Assertions.assertNotNull(atendimentoController.getServiceGenerico());
    }

    @Test
    void salvar() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(atendimentoController).build();
        Mockito.doReturn(atendimento).when(atendimentoRepository).save(atendimento);
        Mockito.doReturn(atendimento).when(atendimentoService).salvar(atendimento);
        System.out.println(objectMapper.writeValueAsString(atendimento));

        mockMvc.perform(MockMvcRequestBuilders.post("/atendimentos")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(atendimento)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void buscarPorId() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(atendimentoController).build();
        Mockito.doReturn(atendimentoOptional).when(atendimentoRepository).findById(Mockito.anyLong());
        Mockito.doReturn(atendimento).when(atendimentoService).buscarEntidadePorId(Mockito.anyLong());

        mockMvc.perform(MockMvcRequestBuilders.get("/atendimentos/{id}", 1L))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void atualizarPorId() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(atendimentoController).build();
        atendimento.setCobrar_cliente(false);
        Mockito.doReturn(true).when(atendimentoRepository).existsById(Mockito.anyLong());
        Mockito.doReturn(atendimento).when(atendimentoRepository).save(atendimento);
        Mockito.doReturn(atendimento).when(atendimentoService).atualizarPorId(1L,atendimento);

        mockMvc.perform(MockMvcRequestBuilders.put("/atendimentos/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(atendimento)))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void deletarPorId() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(atendimentoController).build();
        Mockito.doNothing().when(atendimentoRepository).delete(atendimento);
        Mockito.doNothing().when(atendimentoService).delete(Mockito.anyLong());

        mockMvc.perform(MockMvcRequestBuilders.delete("/atendimentos", 1L))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    void pesquisar() {
        
    }


}