package com.atendimento.controllers;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ControllerGenerico {

    public ResponseEntity<?> retornarObjeto(Long id);
    public ResponseEntity<?> salvarObjeto(Object entidade);
    public ResponseEntity<List> retornarTodosObjetos();
    public ResponseEntity<?> alterarObjeto(Object objeto, Long id);
    public ResponseEntity<Boolean> excluirObjeto(Long id);


}
