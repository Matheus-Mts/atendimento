package com.atendimento.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;


/**
 * Entidade cliente do sistema.
 *
 * @author Matheus Santos.
 * @since 03/09/2021.
 */

@Entity
@Table(name = "cliente")
public class Cliente extends EntidadeGenerica {


    /**
     * Ca do cliente.
     */
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_cliente")
    private Ca ca;

    /**
     * Codigo cliente.
     */
    @Column(name = "codigo_cliente", nullable = false)
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
    public Cliente(Long id, Ca ca, String nome_cliente, String cidade_cliente, String uf_cliente, Long codigo_cliente) {
        super(id);
        this.ca = ca;
        this.nome_cliente = nome_cliente;
        this.cidade_cliente = cidade_cliente;
        this.uf_cliente = uf_cliente;
        this.codigo_cliente = codigo_cliente;
    }

    public Cliente(Ca ca, String nome_cliente, String cidade_cliente, String uf_cliente, Long codigo_cliente) {
        this.ca = ca;
        this.nome_cliente = nome_cliente;
        this.cidade_cliente = cidade_cliente;
        this.uf_cliente = uf_cliente;
        this.codigo_cliente = codigo_cliente;
    }



    public Cliente() {}

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
    public String toString() {
        return "Cliente{" +
                "ca=" + ca +
                ", codigo_cliente=" + codigo_cliente +
                ", nome_cliente='" + nome_cliente + '\'' +
                ", cidade_cliente='" + cidade_cliente + '\'' +
                ", uf_cliente='" + uf_cliente + '\'' +
                '}';
    }
}
