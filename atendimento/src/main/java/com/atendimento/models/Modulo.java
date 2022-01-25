package com.atendimento.models;

import java.io.Serializable;

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
public class Modulo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Id da entidade.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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
    public Modulo(long id, String nomeModulo) {
        this.id = id;
        this.nomeModulo = nomeModulo;
    }

    public Modulo() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeModulo() {
        return nomeModulo;
    }

    public void setNomeModulo(String nomeModulo) {
        this.nomeModulo = nomeModulo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((nomeModulo == null) ? 0 : nomeModulo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Modulo other = (Modulo) obj;
        if (id != other.id)
            return false;
        if (nomeModulo == null) {
            if (other.nomeModulo != null)
                return false;
        } else if (!nomeModulo.equals(other.nomeModulo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Modulo [id=" + id + ", nome_modulo=" + nomeModulo + "]";
    }


}
