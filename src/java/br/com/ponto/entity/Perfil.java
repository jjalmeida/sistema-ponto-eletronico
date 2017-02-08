package br.com.ponto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * 
 * @author jojalmeida
 *
 */
@Entity
public class Perfil {

	@Id
	@GeneratedValue
	@Column(name = "id_perfil")
	private Long id;

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

}
