package com.atendimento.services;

import com.atendimento.models.EntidadeGenerica;
import com.atendimento.repository.RepositoryGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import javassist.NotFoundException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class ServiceGenericoImpl<T extends EntidadeGenerica, ID extends Serializable> {


    @Autowired
    protected abstract RepositoryGenerico<T, ID> getRepositoryGenerico();

    /**
     * Método genérico que salva um objeto do tipo T (especificado em runtime)
     *
     * @param objeto objeto a ser salvo.
     * @return {@link T}. objeto salvo.
     */
    public T salvar(T objeto) throws Exception {
        return getRepositoryGenerico().save(objeto);
    }

    /**
     * Método genérico que atualiza um objeto do tipo T (especificado em runtime)
     *
     * @param id     Identificador do Objeto.
     * @param objeto Objeto a ser atualizado.
     * @return {@link T}. Objeto atualizado.
     * @throws NotFoundException retornar uma exception caso não encontre o objeto T.
     */
    public T atualizarPorId(ID id, final T objeto) throws NotFoundException {
        if (getRepositoryGenerico().existsById(id)) {
            return getRepositoryGenerico().save(objeto);
        } else {
            throw new NotFoundException("Objeto não encontrado no repositorio");
        }
    }

    /**
     * Método genérico que deleta fisicamente um objeto do
     * tipo T, objeto que será especificado durante o runtime.
     *
     * @param id Id do objeto que será deletado.
     */
    public Boolean delete(ID id) {
        if (getRepositoryGenerico().existsById(id)) {
            getRepositoryGenerico().deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    /**
     * Método que faz uma buscar paginada e retorna uma lista de objeto especificado em runtime.
     *
     * @param pageable   objeto Pageable para a pesquisa.
     * @param ehPaginado se a pesquisa é paginada ou não.
     * @return {@link Page <T>}. Paginas com o resultado da pesquisa,
     * com limite de entidades por página.
     */
    public Page<T> pesquisarPaginado(Pageable pageable, boolean ehPaginado) {
        if (ehPaginado) {
            return getRepositoryGenerico().findAll(pageable);
        }
        return new PageImpl<>(getRepositoryGenerico().findAll());
    }

    /**
     * Método para buscar entidade por id.
     *
     * @param id Identificador da entidade.
     * @return {@link T} Retorna um objeto de uma entidade caso exista.
     */
    public Optional<T> buscarEntidadePorId(Long id) {
        return getRepositoryGenerico().findById((ID) id);
    }



}
