package com.atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atendimento.models.Atendimento;

import java.util.List;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

}
