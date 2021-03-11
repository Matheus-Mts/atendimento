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

@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "SENHA_USUARIO")
	private String senha_usuario;
	
	@Column(name = "nome_usuario")
	private String nome_usuario;
	
	@OneToMany
	@JoinColumn(name = "id_modulo")
    private List<Modulo> Modulos;

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
		return Modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		Modulos = modulos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Modulos == null) ? 0 : Modulos.hashCode());
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
		Usuarios other = (Usuarios) obj;
		if (Modulos == null) {
			if (other.Modulos != null)
				return false;
		} else if (!Modulos.equals(other.Modulos))
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
				+ ", Modulos=" + Modulos + "]";
	}
	
	

}
