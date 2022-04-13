package com.atendimento.controllers;

import com.atendimento.models.*;
import com.atendimento.models.dto.UsuarioDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class AtendimentoControllerImplTest {

    @Autowired
    private WebApplicationContext context;

    MockMvc mockMvc;

    Atendimento atendimento;

    Ca ca;

    Cliente cliente;

    Modulo modulo;

    Assunto assunto;

    UsuarioDTO usuarioDTO;

    Sugestao sugestao;


    private  final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        this.ca = new Ca(14L,"matheus","Londrina","Pr",98L);
        this.cliente = new Cliente(1L,ca,"nike","Londrina","PR",20L);
        this.modulo = new Modulo(1L,"teste");
        this.assunto = new Assunto(1L,"teste",modulo);
        this.usuarioDTO = new UsuarioDTO(1L,"teste","teste");
        this.sugestao = new Sugestao(1L,"teste");
        this.atendimento = new Atendimento(1L,ca,cliente,modulo,"teste",null,
                true,"teste",true,assunto,"teste",
                "teste",true,"teste",
                sugestao,usuarioDTO);
    }

    @Test
    void salvar_returnIsCreated() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/atendimento")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(atendimento)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void salvar_returnIsBadRequest() throws Exception{
        atendimento.setTipo_atendimento(null);
        mockMvc.perform(MockMvcRequestBuilders.post("/atendimento")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(atendimento)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void buscarPorId_returnIsOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/atendimento/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void buscarPorId_returnIsBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/atendimento/1123"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void atualizarPorId_returnIsOk() throws Exception {
        this.atendimento.setContato("hahahahahaha");
        mockMvc.perform(MockMvcRequestBuilders.put("/atendimento/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(this.atendimento)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deletarPorId_returnIsOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/atendimento/2"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void deletarPorId_returnIsNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/atendimento/22341"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void pesquisar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/atendimento"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}