package com.atendimento.controllers.impl;

import java.util.Optional;

import com.atendimento.controllers.ControllerGenerico;
import com.atendimento.models.Modulo;
import com.atendimento.services.AtendimentoService;
import com.atendimento.services.ServiceGenericoImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.atendimento.models.Atendimento;

import javax.swing.text.html.Option;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/atendimento")
public class AtendimentoControllerImpl implements ControllerGenerico<Atendimento,Long> {

	@Autowired
	AtendimentoService atendimentoService;


	private ServiceGenericoImpl<Atendimento, Long> getServiceGenerico() {
		return atendimentoService;
	}

	public AtendimentoControllerImpl(AtendimentoService atendimentoService) {
		this.atendimentoService = atendimentoService;
	}

	@PostMapping
	public ResponseEntity<Atendimento> salvar(@RequestBody Atendimento objeto) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(atendimentoService.salvarAtendimento(objeto).get());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Atendimento> buscarPorId(@PathVariable(value = "id") Long id) {
		Optional<Atendimento> possivelAtendimento = getServiceGenerico().buscarEntidadePorId(id);
		return (possivelAtendimento.isPresent()) ? ResponseEntity.status(HttpStatus.OK).body(possivelAtendimento.get())
												 : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Atendimento> atualizarPorId(@PathVariable Long id, @RequestBody Atendimento objeto) {
		try {
			return Optional.of(getServiceGenerico().atualizarPorId(id,objeto))
					.map(atendimento -> ResponseEntity.status(HttpStatus.OK).body(atendimento))
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		}catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Boolean> deletarPorId(@PathVariable  Long id) {
		if (getServiceGenerico().delete(id)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping
	public ResponseEntity<Page<Atendimento>> pesquisar(final Pageable pageable, final @RequestParam(value = "ehPaginado", defaultValue = "false")
			Boolean ehPaginado) {
		return new ResponseEntity<>(getServiceGenerico().pesquisarPaginado(pageable,ehPaginado), HttpStatus.OK);
	}


}
