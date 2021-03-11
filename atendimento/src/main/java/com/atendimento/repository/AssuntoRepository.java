package com.atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atendimento.models.Assunto;

public interface AssuntoRepository extends JpaRepository<Assunto, Long>{
	

}
