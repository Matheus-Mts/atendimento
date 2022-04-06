package com.atendimento.repository;

import com.atendimento.models.dto.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioDTO,Long> {
}
