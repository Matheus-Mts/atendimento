package com.atendimento.services;

import com.atendimento.models.Atendimento;
import com.atendimento.models.Ca;
import com.atendimento.repository.CaRepository;
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

class CaServiceTest {

    @InjectMocks
    private CaService caService;

    @Mock
    private CaRepository caRepository;

    private Ca ca;

    private Optional<Ca> caOptional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ca = new Ca(1L,"teste","cidade","uf",1L);
        caOptional = Optional.of(ca);
    }

    @Test
    void getRepositoryGenerico() {
        Assertions.assertNotNull(caService.getRepositoryGenerico());
    }

    @Test
    void retornarCa() {
        Mockito.doReturn(caOptional).when(caRepository).findById(Mockito.anyLong());
        Optional<Ca> response = caService.retornarCa(1L);
        Assertions.assertNotNull(response);
    }

}