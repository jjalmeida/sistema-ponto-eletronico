package br.com.ponto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TeamLeader {

	@Id
	@GeneratedValue
	@Column(name = "id_team_leader")
	private long id;

	private String descricao;

	private String nome;

	public String getDescricao() {
		return descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getId() {
		return id;
	}
}
