package com.atendimento.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	 
	 
	 public List<Atendimento> listaProdutos(){
		 return atendimentoRepository.findAll();
	 }
	 
	 
	 public Optional<Atendimento> listaAtendimentooUnico(@PathVariable(value="id") Long id) {
		 return atendimentoRepository.findById(id);
	 }
	 
	 
	 public Atendimento salvarAtendimentos(@RequestBody Atendimento atendimento) {
		 return atendimentoRepository.save(atendimento);
	 }
	 
	 
	 public ResponseEntity<Atendimento> deletarAtendimento(@RequestBody Atendimento atendimento) {
		 return new ResponseEntity<Atendimento>(HttpStatus.OK);
	 }
	
}
