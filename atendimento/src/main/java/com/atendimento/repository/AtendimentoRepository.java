package com.atendimento.repository;

import com.atendimento.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import com.atendimento.models.Atendimento;

import java.util.List;
import java.util.Optional;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

    List<Atendimento> findByUsuario(Usuario usuario);
}
