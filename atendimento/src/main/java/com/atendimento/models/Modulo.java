package com.atendimento.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "modulo")
public class Modulo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "nome_modulo")
	private String nome_modulo;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome_modulo() {
		return nome_modulo;
	}

	public void setNome_modulo(String nome_modulo) {
		this.nome_modulo = nome_modulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome_modulo == null) ? 0 : nome_modulo.hashCode());
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
		Modulo other = (Modulo) obj;
		if (id != other.id)
			return false;
		if (nome_modulo == null) {
			if (other.nome_modulo != null)
				return false;
		} else if (!nome_modulo.equals(other.nome_modulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Modulo [id=" + id + ", nome_modulo=" + nome_modulo + "]";
	}
	
	
	
	
	
	
}
