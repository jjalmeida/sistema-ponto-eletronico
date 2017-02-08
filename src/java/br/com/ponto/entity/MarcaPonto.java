package br.com.ponto.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "marca_ponto")
public class MarcaPonto {

	@Id
	@GeneratedValue
	@Column(name = "id_ponto")
	private long id;

	@Temporal(TemporalType.DATE)
	private Date data;

	@Temporal(TemporalType.TIME)
	private Date entradaManha;

	@Temporal(TemporalType.TIME)
	private Date saidaManha;

	@Temporal(TemporalType.TIME)
	private Date entradaTarde;

	@Temporal(TemporalType.TIME)
	private Date saidaTarde;

	@ManyToOne
	private Funcionario funcionario;

	@OneToOne
	private Justificativa justificativa;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getEntradaManha() {
		return entradaManha;
	}

	public void setEntradaManha(Date entradaManha) {
		this.entradaManha = entradaManha;
	}

	public Date getSaidaManha() {
		return saidaManha;
	}

	public void setSaidaManha(Date saidaManha) {
		this.saidaManha = saidaManha;
	}

	public Date getEntradaTarde() {
		return entradaTarde;
	}

	public void setEntradaTarde(Date entradaTarde) {
		this.entradaTarde = entradaTarde;
	}

	public Date getSaidaTarde() {
		return saidaTarde;
	}

	public void setSaidaTarde(Date saidaTarde) {
		this.saidaTarde = saidaTarde;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public long getId() {
		return id;
	}

	public Justificativa getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(Justificativa justificativa) {
		this.justificativa = justificativa;
	}

}
