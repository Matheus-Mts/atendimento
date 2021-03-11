package com.atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atendimento.models.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

}
