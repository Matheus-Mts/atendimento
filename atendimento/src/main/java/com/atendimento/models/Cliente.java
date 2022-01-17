package com.atendimento.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * Entidade cliente do sistema.
 *
 * @author Matheus Santos.
 * @since 03/09/2021.
 */

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * Ca do cliente.
     */
    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Ca ca;

    /**
     * Codigo cliente.
     */
    @Column(name = "codigo_cliente")
    private Long codigo_cliente;

    /**
     * Nome do cliente.
     */
    @Column(name = "nome_cliente")
    private String nome_cliente;

    /**
     * cidade do cliente.
     */
    @Column(name = "cidade_cliente")
    private String cidade_cliente;

    /**
     * uf do cliente.
     */
    @Column(name = "uf_cliente")
    private String uf_cliente;

    /**
     * Construtor com todos os parametros
     *
     * @param id             id da entidade
     * @param ca             ca docliente
     * @param nome_cliente   nome do cliente do atendimento
     * @param cidade_cliente cidade do cliente
     * @param uf_cliente     uf do cliente
     */
    public Cliente(long id, Ca ca, String nome_cliente, String cidade_cliente, String uf_cliente, Long codigo_cliente) {
        this.id = id;
        this.ca = ca;
        this.nome_cliente = nome_cliente;
        this.cidade_cliente = cidade_cliente;
        this.uf_cliente = uf_cliente;
        this.codigo_cliente = codigo_cliente;
    }

    public Cliente() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Ca getCa() {
        return ca;
    }

    public void setCa(Ca ca) {
        this.ca = ca;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getCidade_cliente() {
        return cidade_cliente;
    }

    public void setCidade_cliente(String cidade_cliente) {
        this.cidade_cliente = cidade_cliente;
    }

    public String getUf_cliente() {
        return uf_cliente;
    }

    public void setUf_cliente(String uf_cliente) {
        this.uf_cliente = uf_cliente;
    }

    public Long getCodigo_cliente() { return codigo_cliente;  }

    public void setCodigo_cliente(Long codigo_cliente) {  this.codigo_cliente = codigo_cliente;  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id &&
                Objects.equals(ca, cliente.ca) &&
                Objects.equals(codigo_cliente, cliente.codigo_cliente) &&
                Objects.equals(nome_cliente, cliente.nome_cliente) &&
                Objects.equals(cidade_cliente, cliente.cidade_cliente) &&
                Objects.equals(uf_cliente, cliente.uf_cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ca, codigo_cliente, nome_cliente, cidade_cliente, uf_cliente);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", ca=" + ca +
                ", codigo_cliente=" + codigo_cliente +
                ", nome_cliente='" + nome_cliente + '\'' +
                ", cidade_cliente='" + cidade_cliente + '\'' +
                ", uf_cliente='" + uf_cliente + '\'' +
                '}';
    }


}
