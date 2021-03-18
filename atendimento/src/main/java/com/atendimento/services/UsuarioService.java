package com.atendimento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atendimento.models.Usuario;
import com.atendimento.repository.UsuariosRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuariosRepository usuariosRepository;

	
	public UsuarioService(UsuariosRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;
	}
	
	public List<Usuario> listarTodosUsuariosService() {
		return this.usuariosRepository.findAll();
	}
	
	
	

}
