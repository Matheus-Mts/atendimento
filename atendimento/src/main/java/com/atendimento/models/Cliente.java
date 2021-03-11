package com.atendimento.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	@JoinColumn(name = "id_cliente")
	private Ca ca;
	
	@Column(name = "nome_cliente")
	private String nome_cliente;
	
	@Column(name = "cidade_cliente")
	private String cidade_cliente;
	
	@Column(name = "uf_cliente")
	private String uf_cliente;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ca == null) ? 0 : ca.hashCode());
		result = prime * result + ((cidade_cliente == null) ? 0 : cidade_cliente.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome_cliente == null) ? 0 : nome_cliente.hashCode());
		result = prime * result + ((uf_cliente == null) ? 0 : uf_cliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (ca == null) {
			if (other.ca != null)
				return false;
		} else if (!ca.equals(other.ca))
			return false;
		if (cidade_cliente == null) {
			if (other.cidade_cliente != null)
				return false;
		} else if (!cidade_cliente.equals(other.cidade_cliente))
			return false;
		if (id != other.id)
			return false;
		if (nome_cliente == null) {
			if (other.nome_cliente != null)
				return false;
		} else if (!nome_cliente.equals(other.nome_cliente))
			return false;
		if (uf_cliente == null) {
			if (other.uf_cliente != null)
				return false;
		} else if (!uf_cliente.equals(other.uf_cliente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", ca=" + ca + ", nome_cliente=" + nome_cliente + ", cidade_cliente="
				+ cidade_cliente + ", uf_cliente=" + uf_cliente + "]";
	}
	


}
