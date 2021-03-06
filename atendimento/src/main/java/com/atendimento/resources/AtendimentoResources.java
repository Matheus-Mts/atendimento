package com.atendimento.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atendimento.models.Atendimento;
import com.atendimento.repository.AtendimentoRepository;

@RestController
@RequestMapping(value = "/api")
public class AtendimentoResources {
	

	 @Autowired
	 AtendimentoRepository atendimentoRepository;
	 
	 @GetMapping("/atendimentos")
	 public List<Atendimento> listaProdutos(){
		 return atendimentoRepository.findAll();
	 }
	 
	 @GetMapping("/atendimento/{id}")
	 public Optional<Atendimento> listaAtendimentooUnico(@PathVariable(value="id") Long id) {
		 return atendimentoRepository.findById(id);
	 }
	 
	 @PostMapping("/atendimento")
	 public Atendimento salvarAtendimentos(@RequestBody Atendimento atendimento) {
		 return atendimentoRepository.save(atendimento);
	 }
	
}
