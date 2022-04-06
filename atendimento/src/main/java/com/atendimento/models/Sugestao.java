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
public class Sugestao extends EntidadeGenerica {
	
	private static final long serialVersionUID = 1L;

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
		super(id);
		this.descricao_sugestao = descricao_sugestao;
	}

	public String getDescricao_sugestao() {
		return descricao_sugestao;
	}

	public void setDescricao_sugestao(String descricao_sugestao) {
		this.descricao_sugestao = descricao_sugestao;
	}

	@Override
	public String toString() {
		return "Sugestao{" +
				"descricao_sugestao='" + descricao_sugestao + '\'' +
				'}';
	}
}
