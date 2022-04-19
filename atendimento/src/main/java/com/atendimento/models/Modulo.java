package com.atendimento.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Entidade modulo do atendimento do sistema.
 *
 * @author Matheus Santos.
 * @since 03/09/2021.
 */

@Entity
@Table(name = "modulo")
public class Modulo extends EntidadeGenerica {

    private static final long serialVersionUID = 1L;
    /**
     * Nome do modulo do atendimento.
     */
    @Column(name = "nome_modulo")
    private String nomeModulo;

    /**
     * Método construtor com todos os parametros.
     *
     * @param id          id da entidade.
     * @param nomeModulo nome do modulo.
     */
    public Modulo(Long id, String nomeModulo) {
        super(id);
        this.nomeModulo = nomeModulo;
    }
    public Modulo(){}

    public String getNomeModulo() {
        return nomeModulo;
    }

    public void setNomeModulo(String nomeModulo) {
        this.nomeModulo = nomeModulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modulo modulo = (Modulo) o;
        return Objects.equals(nomeModulo, modulo.nomeModulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeModulo);
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "nomeModulo='" + nomeModulo + '\'' +
                '}';
    }
}
