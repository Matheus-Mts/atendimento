package com.atendimento.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidade sugestão do sistema.
 *
 * @author Matheus Santos.
 * @since 03/09/2021.
 */

@Entity
@Table(name = "sugestao")
public class Sugestao implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Id da entidade.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/**
	 * descricao da sugestão.
	 */
	@Column(name = "descricao_sugestao")
	private String descricao_sugestao;

	/**
	 * Método construtor com todos os parâmetros.
	 * @param id id da entidade
	 * @param descricao_sugestao descrição da sugestão.
	 */
	public Sugestao(long id, String descricao_sugestao) {
		this.id = id;
		this.descricao_sugestao = descricao_sugestao;
	}

	public Sugestao () {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao_sugestao() {
		return descricao_sugestao;
	}

	public void setDescricao_sugestao(String descricao_sugestao) {
		this.descricao_sugestao = descricao_sugestao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao_sugestao == null) ? 0 : descricao_sugestao.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Sugestao other = (Sugestao) obj;
		if (descricao_sugestao == null) {
			if (other.descricao_sugestao != null)
				return false;
		} else if (!descricao_sugestao.equals(other.descricao_sugestao))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sugestao [id=" + id + ", descricao_sugestao=" + descricao_sugestao + "]";
	}
	
	

	
	
	
	
}
