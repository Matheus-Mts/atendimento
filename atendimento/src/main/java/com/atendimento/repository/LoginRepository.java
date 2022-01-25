package com.atendimento.repository;

import com.atendimento.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login,Long> {

    Login findByEmail(String email);
}
