package com.atendimento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atendimento.models.Usuario;
import com.atendimento.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public List<Usuario> listarUsuarios() {
		return usuarioService.listarTodosUsuariosService();
	}
	
	

}
