package com.atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atendimento.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
