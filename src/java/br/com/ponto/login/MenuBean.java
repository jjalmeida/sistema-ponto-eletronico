package br.com.ponto.login;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SessionScoped
public class MenuBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer index=0;
	
	public Integer getIndex() {
		return index;
	}
	
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public String paginaLogin() {
		this.index = 0;
		return "/login?faces-redirect=true";
	}
	
	public String paginaResetSenhaAnalista(){
		this.index = 1;
		return "/analista/reset-senha-analista?faces-redirect=true";
	}
	
	public String paginaResetSenhaGestor(){
		this.index = 1;
		return "/gestor/reset-senha-gestor?faces-redirect=true";
	}
	
	// Pagina de acesso para analistas
	public String paginaAnalistaPonto() {
		this.index = 0;
		return "/analista/ponto?faces-redirect=true";
	}
	
	public String paginaAnalistaPontoConsulta() {
		this.index = 0;
		return "/analista/ponto-consulta?faces-redirect=true";
	}
	
	
	// Paginas de acesso para gestores
	public String paginaFuncionarios() {
		this.index = 1;
		return "/gestor/funcionarios?faces-redirect=true";
	}
	
	public String paginaPontoDiario() {
		this.index = 1;
		return "/gestor/ponto-diario?faces-redirect=true";
	}
	
	public String paginaPontoConsultaGestores() {
		this.index = 1;
		return "/gestor/ponto-consulta-gestores?faces-redirect=true";
	}
	
	// Paginas de acesso para cadastros
	public String paginaCadastroFuncionario(){
		this.index = 1;
		return "/cadastro/cadastro-funcionario?faces-redirect=true";
	}
	
	public String paginaEscala(){
		this.index = 1;
		return "/cadastro/escala?faces-redirect=true";
	}
	
	public String paginaGestor(){
		this.index = 1;
		return "/cadastro/gestor?faces-redirect=true";
	}
	
	public String paginaJustificativa(){
		this.index = 1;
		return "/cadastro/justificativa?faces-redirect=true";
	}
	
	public String paginaSite(){
		this.index = 1;
		return "/cadastro/site?faces-redirect=true";
	}
	
}
