package com.atendimento.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ca")
public class Ca implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    @Column(name = "nome_ca")
    private String nome_ca;
    
    @Column(name = "cidade_ca")
    private String cidade_ca;
    
    @Column(name = "uf_ca")
    private String uf_ca;
    

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade_ca == null) ? 0 : cidade_ca.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome_ca == null) ? 0 : nome_ca.hashCode());
		result = prime * result + ((uf_ca == null) ? 0 : uf_ca.hashCode());
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
		Ca other = (Ca) obj;
		if (cidade_ca == null) {
			if (other.cidade_ca != null)
				return false;
		} else if (!cidade_ca.equals(other.cidade_ca))
			return false;
		if (id != other.id)
			return false;
		if (nome_ca == null) {
			if (other.nome_ca != null)
				return false;
		} else if (!nome_ca.equals(other.nome_ca))
			return false;
		if (uf_ca == null) {
			if (other.uf_ca != null)
				return false;
		} else if (!uf_ca.equals(other.uf_ca))
			return false;
		return true;
	}
    
    
   

}
