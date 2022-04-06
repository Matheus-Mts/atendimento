package com.atendimento.controllers;

import java.util.List;
import java.util.Optional;

import com.atendimento.models.EntidadeGenerica;
import com.atendimento.services.AtendimentoService;
import com.atendimento.services.ServiceGenericoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.atendimento.models.Atendimento;
import com.atendimento.repository.AtendimentoRepository;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/atendimentos")
public class AtendimentoController extends ControllerGenerico<Atendimento,Long> {

	@Autowired
	AtendimentoService atendimentoService;

	@Override
	protected ServiceGenericoImpl<Atendimento, Long> getServiceGenerico() {
		return atendimentoService;
	}

	public AtendimentoController(AtendimentoService atendimentoService) {
		this.atendimentoService = atendimentoService;
	}

}
