package br.com.ponto.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Escala {


	@Id
	@GeneratedValue
	@Column(name = "id_escala")
	private long id;

	private String descricao;

	@Temporal(TemporalType.TIME)
	private Date entrada;

	@Temporal(TemporalType.TIME)
	private Date saida;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

	public long getId() {
		return id;
	}

}
