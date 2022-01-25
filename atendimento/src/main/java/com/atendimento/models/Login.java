package com.atendimento.models;


import javax.persistence.*;
import java.io.Serializable;


/**
 * Entidade login do sistema.
 *
 * @author Matheus Santos.
 * @since 03/09/2021.
 */

@Entity
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Id da entidade.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * Email do login.
     */
    @Column(name = "email", unique = true)
    private String email;

    /**
     * senha do login
     */
    @Column(name = "senha")
    private String senha;

    /**
     * Método construtor com todos os parametros.
     *
     * @param id    id da entidade.
     * @param email email do login.
     * @param senha senha do login.
     */
    public Login(long id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public Login(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }


    public Login() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
