package com.atendimento.services;

import com.atendimento.models.Modulo;
import com.atendimento.repository.ModuloRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ModuloServiceTest {

    @InjectMocks
    private ModuloService moduloService;

    @Mock
    private ModuloRepository moduloRepository;

    private Modulo modulo;

    private Optional<Modulo> moduloOptional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        modulo = new Modulo(1L,"teste");
        moduloOptional = Optional.of(modulo);
    }

    @Test
    void getRepositoryGenerico() {
        Assertions.assertNotNull(moduloService.getRepositoryGenerico());
    }

    @Test
    void retornarModuloPorId() {
        Mockito.doReturn(moduloOptional).when(moduloRepository).findById(Mockito.anyLong());
        Optional<Modulo> response = moduloService.retornarModuloPorId(1L);
        Assertions.assertNotNull(response);
    }

    @Test
    void retornarModuloPorNome() {
        Mockito.doReturn(moduloOptional).when(moduloRepository).findBynomeModulo(Mockito.anyString());
        Optional<Modulo> response = moduloService.retornarModuloPorNome("teste");
        Assertions.assertNotNull(response);
    }
}