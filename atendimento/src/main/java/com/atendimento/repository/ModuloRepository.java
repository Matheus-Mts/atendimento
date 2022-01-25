package com.atendimento.repository;

import com.atendimento.models.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo,Long> {

    public Optional<Modulo> findBynomeModulo(String nome_modulo);

}
