package com.atendimento.repository;

import com.atendimento.models.EntidadeGenerica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

@NoRepositoryBean
public interface RepositoryGenerico <T extends EntidadeGenerica, ID extends Serializable> extends JpaRepository<T,ID>,
        PagingAndSortingRepository<T,ID> {


}
