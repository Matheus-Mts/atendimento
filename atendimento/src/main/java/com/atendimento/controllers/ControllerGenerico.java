package com.atendimento.controllers;

import com.atendimento.models.EntidadeGenerica;
import com.atendimento.services.ServiceGenericoImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Controller
public abstract class ControllerGenerico <T extends EntidadeGenerica, ID extends Serializable> {

    /**
     * Método que retorna para o controller, durante o runtime,
     * o service da execução atual.
     *
     * @return {@link ServiceGenericoImpl<T, ID>}. Service genérico.
     */
    @Autowired
    protected abstract ServiceGenericoImpl<T,ID> getServiceGenerico();

    /**
     * Método genérico que salva um objeto do tipo T,
     * objeto que será especificado durante o runtime.
     *
     * @param objeto Objeto a ser salvo.
     * @return {@link ResponseEntity <T>}. Entidade salva.
     */
    @PostMapping
    public ResponseEntity<T> salvar (@RequestBody T objeto) {
        return ResponseEntity.ok().body(getServiceGenerico().salvar(objeto));
    }

    /**
     * Método generico para busca de um objeto pelo id.
     *
     * @param id Identificador do objeto.
     * @return {@link ResponseEntity<T>} Retorna o objeto caso exista.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<T> buscarPorId(@PathVariable(value = "id")Long id) {
        Optional<T> objGenerico = Optional.ofNullable(getServiceGenerico().buscarEntidadePorId(id));
        return objGenerico.map(objeto -> ResponseEntity.status(HttpStatus.OK).body(objeto))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Método genérico que atualiza um objeto do tipo T,
     * objeto que será especificado durante o runtime.
     *
     * @param objeto Objeto a ser atualizado.
     * @return {@link ResponseEntity<T>}. Entidade atualizada.
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<T> atualizarPorId(@PathVariable ID id, @RequestBody final T objeto) throws NotFoundException {
        Optional<T> objGenerico = Optional.ofNullable(getServiceGenerico().atualizarPorId(id, objeto));
        return objGenerico.map(obj -> ResponseEntity.status(HttpStatus.OK).body(obj))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Método genérico que deleta fisicamente um objeto do
     * tipo T, objeto que será especificado durante o runtime.
     *
     * @param id Id do objeto que será deletado.
     */
    @DeleteMapping
    public void deletarPorId(@PathVariable ID id) { getServiceGenerico().delete(id); }

    /**
     * Método para busca paginada.
     * @param pageable   Objeto Pageable para a pesquisa.
     * @param ehPaginado Pageable Se a pesquisa é pageada ou não. O default é não.
     * @return {@link ResponseEntity<Page<T>>}. Páginas com o resultado da pesquisa.
     */
    @GetMapping
    public ResponseEntity<Page<T>> pesquisar(final Pageable pageable, final @RequestParam(value = "ehPaginado", defaultValue = "false")
            Boolean ehPaginado) {
        return new ResponseEntity<>(getServiceGenerico().pesquisarPaginado(pageable,ehPaginado), HttpStatus.OK);
    }

}
