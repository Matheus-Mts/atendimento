package com.atendimento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atendimento.models.Atendimento;
import com.atendimento.repository.AtendimentoRepository;

@Service
public class AtendimentoService {
	
	@Autowired
	AtendimentoRepository atendimentoRepository;

	public AtendimentoService(AtendimentoRepository atendimentoRepository) {
		this.atendimentoRepository = atendimentoRepository;
	}
	
	public List<Atendimento> listarTodosAtendimentos() {
		return this.atendimentoRepository.findAll();
	}
	
	
	

}
