package com.atendimento.controllers;

import java.util.List;
import java.util.Optional;

import com.atendimento.services.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.atendimento.models.Atendimento;
import com.atendimento.repository.AtendimentoRepository;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/atendimentos")
public class AtendimentoController {
	
	@Autowired
	AtendimentoService atendimentoService;

	public AtendimentoController(AtendimentoService atendimentoService) {
		this.atendimentoService = atendimentoService;
	}

	@GetMapping(value = "/{idUsuario}")
	public ResponseEntity<List<Atendimento>> retornaListaAtendimentoUsuario(@PathVariable Long idUsuario) {
		return atendimentoService.retornaListaAtendimentoUsuario(idUsuario)
				.map(atendimentos -> ResponseEntity.status(HttpStatus.OK).body(atendimentos))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping
	public ResponseEntity<List<Atendimento>> retornarTodosAtendimentos() {
		return atendimentoService.retornarTodosAtendimentos()
				.map(atendimentos -> ResponseEntity.status(HttpStatus.OK).body(atendimentos))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping
	public ResponseEntity<Atendimento> salvarAtendimento(@RequestBody Atendimento atendimento) {
		return atendimentoService.salvarAtendimento(atendimento)
				.map(atendimentoSalvo -> ResponseEntity.status(HttpStatus.CREATED).body(atendimentoSalvo))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
}
