package com.atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atendimento.models.Sugestao;

public interface SugestaoRepository extends JpaRepository<Sugestao, Long> {

}
