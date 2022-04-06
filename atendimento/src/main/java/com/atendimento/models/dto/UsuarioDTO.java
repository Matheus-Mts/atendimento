package com.atendimento.models.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

@Entity(name = "usuario")
public class UsuarioDTO implements Serializable {

    @Id
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Transient
    private String senha;


    public UsuarioDTO(Long id, String email, String cpf) {
        this.id = id;
        this.email = email;
        this.cpf = cpf;
    }

    public UsuarioDTO(Long id, String email, String cpf, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public UsuarioDTO (){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
