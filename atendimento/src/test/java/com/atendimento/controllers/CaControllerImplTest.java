package com.atendimento.controllers;

import com.atendimento.models.Ca;
import com.atendimento.models.Modulo;
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
class CaControllerImplTest {

    @Autowired
    private WebApplicationContext context;

    MockMvc mockMvc;
    
    Ca ca;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        this.ca = new Ca("matheus","Londrina","Pr",98L);
    }
    


    @Test
    void salvar_returnIsCreated() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders.post("/ca")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(ca)))
                .andDo(print())
                .andExpect(status().isCreated());

    }

    @Test
    void salvar_returnBadRequest() throws Exception {
        
        mockMvc.perform(MockMvcRequestBuilders.post("/ca")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(new Modulo())))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }

    @Test
    void buscarPorId_returnIsOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ca/2"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void buscarPorId_returnIsNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ca/2659"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void atualizarPorId_returnIsOk() throws Exception {
        this.ca.setCidade_ca("Caioba");

        mockMvc.perform(MockMvcRequestBuilders.put("/ca/2")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(this.ca)))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void atualizarPorId_returnIsNotFound() throws Exception {
        this.ca.setCidade_ca("Caioba");

        mockMvc.perform(MockMvcRequestBuilders.put("/ca/959")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(this.ca)))
                .andDo(print())
                .andExpect(status().isNotFound());

    }

    @Test
    void deletarPorId_returnIsOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/ca/6"))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    void deletarPorId_returnIsNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/ca/99"))
                .andExpect(status().isNotFound())
                .andDo(print());

    }

    @Test
    void pesquisar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ca"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}