package com.atendimento.controllers.impl;

import com.atendimento.controllers.ControllerGenerico;
import com.atendimento.models.Ca;
import com.atendimento.models.Modulo;
import com.atendimento.services.ModuloService;
import com.atendimento.services.ServiceGenericoImpl;
import javassist.NotFoundException;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/modulo")
public class ModuloControllerImpl implements ControllerGenerico<Modulo,Long> {

    @Autowired
    private ModuloService moduloService;


    protected ServiceGenericoImpl<Modulo, Long> getServiceGenerico() {
        return moduloService;
    }

    public ModuloControllerImpl(ModuloService moduloService) {
        this.moduloService = moduloService;
    }

    @GetMapping(value = "/nome/{nome_modulo}")
    public ResponseEntity<Modulo> retornarModulo(@PathVariable String nome_modulo ) {
        return moduloService.retornarModuloPorNome(nome_modulo)
                .map(modulo -> ResponseEntity.status(HttpStatus.OK).body(modulo))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Modulo> salvar(@RequestBody  Modulo objeto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(getServiceGenerico().salvar(objeto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Modulo> buscarPorId(@PathVariable(value = "id") Long id) {
        Optional<Modulo> possivelModulo = getServiceGenerico().buscarEntidadePorId(id);
        return (possivelModulo.isPresent()) ? ResponseEntity.status(HttpStatus.OK).body(possivelModulo.get()) :
                                              ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Modulo> atualizarPorId(@PathVariable Long id, @RequestBody Modulo objeto)  {
        try {
            return Optional.of(getServiceGenerico().atualizarPorId(id,objeto))
                    .map(modulo -> ResponseEntity.status(HttpStatus.OK).body(modulo))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        }catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deletarPorId(@PathVariable  Long id) {
        if (getServiceGenerico().delete(id)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<Modulo>> pesquisar(final Pageable pageable, final @RequestParam(value = "ehPaginado", defaultValue = "false")
            Boolean ehPaginado) {
        return new ResponseEntity<>(getServiceGenerico().pesquisarPaginado(pageable,ehPaginado), HttpStatus.OK);
    }
}
