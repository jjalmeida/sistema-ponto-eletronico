package br.com.ponto.login;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import br.com.ponto.entity.Funcionario;

@Named
@ManagedBean
@SessionScoped
public class UsuarioLogadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Funcionario usuario;

	public void logar(Funcionario usuario) {
		this.usuario = usuario;
	}

	public void deslogar() {
		this.usuario = null;
	}
	
	public Funcionario getUsuario() {
		return usuario;
	}

	public boolean isLogado() {
		return usuario != null;
	}
}
