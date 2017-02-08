package br.com.ponto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 
 * @author jojalmeida
 *
 */

@Entity
public class Funcionario {

	@Id
	@GeneratedValue
	@Column(name = "id_funcionario")
	private long id;

	private String nome;

	@Column(unique=true)
	private String employeeId;

	@Column(unique=true)
	private String cpf;

	private String senha;

	@OneToOne
	private Perfil perfil;

	@OneToOne
	private Site site;

	@OneToOne
	private Status status;

	@OneToOne
	private Escala escala;

	@OneToOne
	private Gestor gestor;

	@OneToOne
	private TeamLeader teamLeader;

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Escala getEscala() {
		return escala;
	}

	public void setEscala(Escala escala) {
		this.escala = escala;
	}

	public Gestor getGestor() {
		return gestor;
	}

	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}

	public TeamLeader getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(TeamLeader teamLeader) {
		this.teamLeader = teamLeader;
	}
}
