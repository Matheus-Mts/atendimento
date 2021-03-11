package com.atendimento.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assunto")
public class Assunto implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "tipo_assunto")
	private String tipo_assunto;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Modulo modulo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo_assunto() {
		return tipo_assunto;
	}

	public void setTipo_assunto(String tipo_assunto) {
		this.tipo_assunto = tipo_assunto;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((modulo == null) ? 0 : modulo.hashCode());
		result = prime * result + ((tipo_assunto == null) ? 0 : tipo_assunto.hashCode());
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
		Assunto other = (Assunto) obj;
		if (id != other.id)
			return false;
		if (modulo == null) {
			if (other.modulo != null)
				return false;
		} else if (!modulo.equals(other.modulo))
			return false;
		if (tipo_assunto == null) {
			if (other.tipo_assunto != null)
				return false;
		} else if (!tipo_assunto.equals(other.tipo_assunto))
			return false;
		return true;
	}
	
	
	
	
  
  
}
