package com.atendimento.repository;

import com.atendimento.models.Atendimento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtendimentoRepository extends RepositoryGenerico<Atendimento, Long> {

}
