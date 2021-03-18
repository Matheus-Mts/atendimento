package com.atendimento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atendimento.models.Atendimento;
import com.atendimento.services.AtendimentoService;

@RestController
@RequestMapping(value = "/atendimentos")
public class AtendimentoController {
	
	@Autowired
	AtendimentoService atendimentoService;
	
	public AtendimentoController(AtendimentoService atendimentoService) {
		this.atendimentoService = atendimentoService;
	}
	
	@GetMapping
	public ResponseEntity<Atendimento> listarAtendimentos() {
		return new ResponseEntity<Atendimento>((Atendimento) atendimentoService.listarTodosAtendimentos(), HttpStatus.OK);		
	}

}
	