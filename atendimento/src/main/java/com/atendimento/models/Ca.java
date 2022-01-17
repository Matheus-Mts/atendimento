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
 * Entidade ca do sistema.
 *
 * @author Matheus Santos.
 * @since 03/09/2021.
 */

@Entity
@Table(name = "ca")
public class Ca implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Id da entidade.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    /**
     * Codigo da ca.
     */
    @Column(name = "codigo_ca")
    private long codigo_ca;

    /**
     * Nome da ca.
     */
    @Column(name = "nome_ca")
    private String nome_ca;

    /**
     * cidade da ca.
     */
    @Column(name = "cidade_ca")
    private String cidade_ca;

    /**
     * uf da ca.
     */
    @Column(name = "uf_ca")
    private String uf_ca;

    /**
     * Método consturtor com todos os parametros.
     * @param id id da entidade.
     * @param nome_ca nome da ca.
     * @param cidade_ca cidade da ca.
     * @param uf_ca uf da ca.
     * @param codigo_ca codigo da ca.
     */
    public Ca(long id, String nome_ca, String cidade_ca, String uf_ca, Long codigo_ca) {
        this.id = id;
        this.nome_ca = nome_ca;
        this.cidade_ca = cidade_ca;
        this.uf_ca = uf_ca;
        this.codigo_ca = codigo_ca;
    }


    public Ca() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome_ca() {
        return nome_ca;
    }

    public void setNome_ca(String nome_ca) {
        this.nome_ca = nome_ca;
    }

    public String getCidade_ca() {
        return cidade_ca;
    }

    public void setCidade_ca(String cidade_ca) {
        this.cidade_ca = cidade_ca;
    }

    public String getUf_ca() {
        return uf_ca;
    }

    public void setUf_ca(String uf_ca) {
        this.uf_ca = uf_ca;
    }

    public long getCodigo_ca() {  return codigo_ca; }

    public void setCodigo_ca(long codigo_ca) { this.codigo_ca = codigo_ca;   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ca ca = (Ca) o;
        return id == ca.id &&
                codigo_ca == ca.codigo_ca &&
                Objects.equals(nome_ca, ca.nome_ca) &&
                Objects.equals(cidade_ca, ca.cidade_ca) &&
                Objects.equals(uf_ca, ca.uf_ca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo_ca, nome_ca, cidade_ca, uf_ca);
    }

    @Override
    public String toString() {
        return "Ca{" +
                "id=" + id +
                ", codigo_ca=" + codigo_ca +
                ", nome_ca='" + nome_ca + '\'' +
                ", cidade_ca='" + cidade_ca + '\'' +
                ", uf_ca='" + uf_ca + '\'' +
                '}';
    }


}
