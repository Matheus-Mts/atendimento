package com.atendimento.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;


/**
 * Entidade de atendimento do sistema.
 *
 * @author Matheus Santos.
 * @since 03/09/2021.
 */

@Entity
@Table(name = "ATENDIMENTO")
public class Atendimento implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id da entidade.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * Ca do cliente do atendimento.
     */
    @OneToOne
    @JoinColumn(name = "id_ca")
    private Ca ca;

    /**
     * Cliente do atendimento.
     */
    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    /**
     * Modulo atendimento.
     */
    @OneToOne
    @JoinColumn(name = "id_modulo")
    private Modulo tipo_modulo;

    /**
     * tipo do atendimento.
     */
    @Column(name = "tipo_atendimento")
    private String tipo_atendimento;

    /**
     * data do atendimento.
     */
    @Column(name = "data_atendimento")
    private LocalDate data_atendimento;

    /**
     * se o atendimento já foi concluido.
     */
    @Column(name = "atendimento_concluido")
    private Boolean atendimento_concluido;

    /**
     * Observações do atendimento.
     */
    @Column(name = "observacoes")
    private String observacoes;

    /**
     * se é pra cobrar o cliente sobre o retorno.
     */
    @Column(name = "cobrar_cliente")
    private Boolean cobrar_cliente;

    /**
     * assunto do atendimento.
     */
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_assunto")
    private Assunto assunto;

    /**
     * Descrição do cliente.
     */
    @Column(name = "descricao_cliente")
    private String descricao_cliente;

    /**
     * Atendimento hora final.
     */
    @Column(name = "atendimento_horafinal")
    private String atendimento_horarfinal;

    /**
     * se o atendimento já foi encerrado.
     */
    @Column(name = "encerrado")
    private Boolean encerrado;

    /**
     * contato do cliente.
     */
    @Column(name = "contato")
    private String contato;

    /**
     * Usuario do atendimento.
     */
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private Usuario usuario;

    /**
     * sugestão do atendimento.
     */
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_sugestao")
    private Sugestao sugestao;

    /**
     * Método construtor com todos os parametros.
     *
     * @param id                     id da entidade.
     * @param ca                     ca do atendimento.
     * @param cliente                cliente do atendimento
     * @param tipo_modulo            modulo do atendimento
     * @param tipo_atendimento       tipo de atendimento
     * @param data_atendimento       data do atendimento
     * @param atendimento_concluido  atendimento concluido
     * @param observacoes            observações do atendimento
     * @param cobrar_cliente         cobrar cliente
     * @param assunto                assunto do atendimento
     * @param descricao_cliente      descrição do cliente.
     * @param atendimento_horarfinal hora final do atendimento
     * @param encerrado              se o atendimento foi finalizado
     * @param contato                contato do atendimento
     * @param usuario                usuario do atendimento
     * @param sugestao               sugestao do atendimento.
     */
    public Atendimento(long id, Ca ca, Cliente cliente, Modulo tipo_modulo, String tipo_atendimento, LocalDate data_atendimento,
                       Boolean atendimento_concluido, String observacoes, Boolean cobrar_cliente,
                       Assunto assunto, String descricao_cliente, String atendimento_horarfinal, Boolean encerrado,
                       String contato, Usuario usuario, Sugestao sugestao) {
        this.id = id;
        this.ca = ca;
        this.cliente = cliente;
        this.tipo_modulo = tipo_modulo;
        this.tipo_atendimento = tipo_atendimento;
        this.data_atendimento = data_atendimento;
        this.atendimento_concluido = atendimento_concluido;
        this.observacoes = observacoes;
        this.cobrar_cliente = cobrar_cliente;
        this.assunto = assunto;
        this.descricao_cliente = descricao_cliente;
        this.atendimento_horarfinal = atendimento_horarfinal;
        this.encerrado = encerrado;
        this.contato = contato;
        this.usuario = usuario;
        this.sugestao = sugestao;
    }

    public Atendimento() {}

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Modulo getTipo_modulo() {
        return tipo_modulo;
    }

    public void setTipo_modulo(Modulo tipo_modulo) {
        this.tipo_modulo = tipo_modulo;
    }

    public String getTipo_atendimento() {
        return tipo_atendimento;
    }

    public void setTipo_atendimento(String tipo_atendimento) {
        this.tipo_atendimento = tipo_atendimento;
    }

    public LocalDate getData_atendimento() {
        return data_atendimento;
    }

    public void setData_atendimento(LocalDate data_atendimento) {
        this.data_atendimento = data_atendimento;
    }

    public Boolean isAtendimento_concluido() {
        return atendimento_concluido;
    }

    public void setAtendimento_concluido(Boolean atendimento_concluido) {
        this.atendimento_concluido = atendimento_concluido;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Boolean isCobrar_cliente() {
        return cobrar_cliente;
    }

    public void setCobrar_cliente(Boolean cobrar_cliente) {
        this.cobrar_cliente = cobrar_cliente;
    }

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

    public String getDescricao_cliente() {
        return descricao_cliente;
    }

    public void setDescricao_cliente(String descricao_cliente) {
        this.descricao_cliente = descricao_cliente;
    }

    public String getAtendimento_horarfinal() {
        return atendimento_horarfinal;
    }

    public void setAtendimento_horarfinal(String atendimento_horarfinal) {
        this.atendimento_horarfinal = atendimento_horarfinal;
    }

    public Boolean isEncerrado() {
        return encerrado;
    }

    public void setEncerrado(Boolean encerrado) {
        this.encerrado = encerrado;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Sugestao getSugestao() {
        return sugestao;
    }

    public void setSugestao(Sugestao sugestao) {
        this.sugestao = sugestao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((assunto == null) ? 0 : assunto.hashCode());
        result = prime * result + (atendimento_concluido ? 1231 : 1237);
        result = prime * result + ((ca == null) ? 0 : ca.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + (cobrar_cliente ? 1231 : 1237);
        result = prime * result + ((contato == null) ? 0 : contato.hashCode());
        result = prime * result + ((data_atendimento == null) ? 0 : data_atendimento.hashCode());
        result = prime * result + ((descricao_cliente == null) ? 0 : descricao_cliente.hashCode());
        result = prime * result + (encerrado ? 1231 : 1237);
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
        result = prime * result + ((sugestao == null) ? 0 : sugestao.hashCode());
        result = prime * result + ((tipo_atendimento == null) ? 0 : tipo_atendimento.hashCode());
        result = prime * result + ((tipo_modulo == null) ? 0 : tipo_modulo.hashCode());
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
        Atendimento other = (Atendimento) obj;
        if (assunto == null) {
            if (other.assunto != null)
                return false;
        } else if (!assunto.equals(other.assunto))
            return false;
        if (atendimento_concluido != other.atendimento_concluido)
            return false;
        if (ca == null) {
            if (other.ca != null)
                return false;
        } else if (!ca.equals(other.ca))
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (cobrar_cliente != other.cobrar_cliente)
            return false;
        if (contato == null) {
            if (other.contato != null)
                return false;
        } else if (!contato.equals(other.contato))
            return false;
        if (data_atendimento == null) {
            if (other.data_atendimento != null)
                return false;
        } else if (!data_atendimento.equals(other.data_atendimento))
            return false;
        if (descricao_cliente == null) {
            if (other.descricao_cliente != null)
                return false;
        } else if (!descricao_cliente.equals(other.descricao_cliente))
            return false;
        if (encerrado != other.encerrado)
            return false;
        if (id != other.id)
            return false;
        if (observacoes == null) {
            if (other.observacoes != null)
                return false;
        } else if (!observacoes.equals(other.observacoes))
            return false;
        if (sugestao == null) {
            if (other.sugestao != null)
                return false;
        } else if (!sugestao.equals(other.sugestao))
            return false;
        if (tipo_atendimento == null) {
            if (other.tipo_atendimento != null)
                return false;
        } else if (!tipo_atendimento.equals(other.tipo_atendimento))
            return false;
        if (tipo_modulo == null) {
            if (other.tipo_modulo != null)
                return false;
        } else if (!tipo_modulo.equals(other.tipo_modulo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Atendimento [id=" + id + ", ca=" + ca + ", cliente=" + cliente + ", tipo_modulo=" + tipo_modulo
                + ", tipo_atendimento=" + tipo_atendimento + ", data_atendimento=" + data_atendimento
                + ", atendimento_concluido=" + atendimento_concluido + ", observacoes=" + observacoes
                + ", cobrar_cliente=" + cobrar_cliente + ", assunto=" + assunto
                + ", descricao_cliente=" + descricao_cliente + ", atendimento_horarfinal=" + atendimento_horarfinal
                + ", encerrado=" + encerrado + ", contato=" + contato + ", sugestao=" + sugestao + "]";
    }


}
	
	
	
	
	
	
	


