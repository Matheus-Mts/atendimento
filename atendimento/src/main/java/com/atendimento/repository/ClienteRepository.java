package com.atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atendimento.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
