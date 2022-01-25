package com.atendimento.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entidade usuarios do sistema.
 *
 * @author Matheus Santos.
 * @since 03/09/2021.
 */

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Id da entidade.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * Senha do usuario.
     */
    @Column(name = "SENHA_USUARIO")
    private String senha_usuario;

    /**
     * Nome do usuario.
     */
    @Column(name = "nome_usuario")
    private String nome_usuario;

    /**
     * Modulos no qual usuario pertence.
     */
    @OneToMany
    @JoinColumn(name = "id_modulo")
    private List<Modulo> modulos;

    /**
     * Lista de atendimentos do usuario.
     */
    @OneToMany
    @JoinColumn(name = "id_atendimento")
    private List<Atendimento> atendimentos;

    /**
     * Método construtor com todos os parâmetros.
     *
     * @param id            id da entidade.
     * @param senha_usuario senha do usuario.
     * @param nome_usuario  nome do usuario.
     * @param modulos       modulos do usuario.
     * @param atendimentos  atendimentos do usuario.
     */
    public Usuario(long id, String senha_usuario, String nome_usuario, List<Modulo> modulos, List<Atendimento> atendimentos) {
        this.id = id;
        this.senha_usuario = senha_usuario;
        this.nome_usuario = nome_usuario;
        this.modulos = modulos;
        this.atendimentos = atendimentos;
    }

    public Usuario() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((modulos == null) ? 0 : modulos.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((nome_usuario == null) ? 0 : nome_usuario.hashCode());
        result = prime * result + ((senha_usuario == null) ? 0 : senha_usuario.hashCode());
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
        Usuario other = (Usuario) obj;
        if (modulos == null) {
            if (other.modulos != null)
                return false;
        } else if (!modulos.equals(other.modulos))
            return false;
        if (id != other.id)
            return false;
        if (nome_usuario == null) {
            if (other.nome_usuario != null)
                return false;
        } else if (!nome_usuario.equals(other.nome_usuario))
            return false;
        if (senha_usuario == null) {
            if (other.senha_usuario != null)
                return false;
        } else if (!senha_usuario.equals(other.senha_usuario))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Usuarios [id=" + id + ", senha_usuario=" + senha_usuario + ", nome_usuario=" + nome_usuario
                + ", Modulos=" + modulos + "]";
    }


}
