package com.atendimento.controllers;

import com.atendimento.models.Ca;
import com.atendimento.models.Cliente;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class ClienteControllerImplTest {

    @Autowired
    private WebApplicationContext context;

    MockMvc mockMvc;

    Cliente cliente;
    
    Ca ca;

    private final ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        this.ca = new Ca(14L,"matheus","Londrina","Pr",98L);
        this.cliente = new Cliente(ca,"nike","Londrina","PR",20L);
    }
    @Test
    void salvar_returnIsCreated() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/cliente")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(cliente)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void salvar_returnIsBadRequest() throws Exception {
        cliente.setCodigo_cliente(null);
        mockMvc.perform(MockMvcRequestBuilders.post("/cliente")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(cliente)))
                .andDo(print())
                .andExpect(status().isBadRequest());
        cliente.setCodigo_cliente(20L);
    }

    @Test
    void buscarPorId_returnIsOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cliente/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void buscarPorId_returnIsNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cliente/10548"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void atualizarPorId_returnIsOk() throws Exception {
        this.cliente.setCidade_cliente("caioba");
        mockMvc.perform(MockMvcRequestBuilders.put("/cliente/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(this.cliente)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void atualizarPorId_returnIsNotFound() throws Exception {
        this.cliente.setCidade_cliente("caioba");
        mockMvc.perform(MockMvcRequestBuilders.put("/cliente/12131")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(this.cliente)))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void deletarPorId_returnIsOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/cliente/2"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void deletarPorId_returnIsNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/cliente/548"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void pesquisar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cliente"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}