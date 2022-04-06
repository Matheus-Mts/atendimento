package com.atendimento.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entidade assunto do atendimento do sistema.
 *
 * @author Matheus Santos.
 * @since 03/09/2021.
 */

@Entity
@Table(name = "assunto")
public class Assunto extends EntidadeGenerica {


    private static final long serialVersionUID = 1L;

    /**
     * Tipo do assunto do atendimento.
     */
    @Column(name = "tipo_assunto")
    private String tipo_assunto;

    /**
     * Modulo do atendimento.
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Modulo modulo;

    /**
     * Construtor padrão com todos os parametros.
     *
     * @param id           id da entidade.
     * @param tipo_assunto tipo do assunto do atendimento.
     * @param modulo       modulo do atendimento.
     */
    public Assunto(Long id, String tipo_assunto, Modulo modulo) {
        super(id);
        this.tipo_assunto = tipo_assunto;
        this.modulo = modulo;
    }

    //getters and setters.

    public String getTipo_assunto() {
        return tipo_assunto;
    }

    public void setTipo_assunto(String tipo_assunto) {
        this.tipo_assunto = tipo_assunto;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    @Override
    public String toString() {
        return "Assunto{" +
                "tipo_assunto='" + tipo_assunto + '\'' +
                ", modulo=" + modulo +
                '}';
    }
}
