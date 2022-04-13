package com.atendimento.controllers;

import com.atendimento.models.EntidadeGenerica;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public interface ControllerGenerico <T extends EntidadeGenerica, ID extends Serializable>  {


    public ResponseEntity<T> salvar (T objeto);


    public ResponseEntity<T> buscarPorId(ID id);


    public ResponseEntity<T> atualizarPorId( ID id,  final T objeto) throws NotFoundException;


    public ResponseEntity<Boolean> deletarPorId(ID id);


    public ResponseEntity<Page<T>> pesquisar(final Pageable pageable, final Boolean ehPaginado);


}
