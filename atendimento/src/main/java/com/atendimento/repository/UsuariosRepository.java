package com.atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atendimento.models.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

}
