package br.com.ponto.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

import br.com.ponto.dao.DAO;
import br.com.ponto.entity.Funcionario;
import br.com.ponto.login.LoginBean;
import br.com.ponto.login.UsuarioLogadoBean;

@ManagedBean
@RequestScoped
public class ResetSenhaBean {

	@Inject
	UsuarioLogadoBean usuario;
	
	@Inject
	private LoginBean login;

	private String novaSenha;

	private Funcionario funcionario;

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public void trocaSenha() {
		funcionario = usuario.getUsuario();

		if (novaSenha.equals("1234")) {
			System.out.println("[INFO] DIGITADO SENHA " + novaSenha);
			ResetSenhaBean
					.menssagem("Essa senha não pode ser usada, tente novamente!!!");
		} else {
			funcionario.setSenha(novaSenha);
			new DAO<Funcionario>(Funcionario.class).atualiza(funcionario);
			ResetSenhaBean.menssagem("Cadastrado nova senha com sucesso!!!");
			this.novaSenha = "";
		}
	}

	public void resetSenhaPadrao(Funcionario funcionario) {
		funcionario.setSenha("1234");
		new DAO<Funcionario>(Funcionario.class).atualiza(funcionario);
		ResetSenhaBean
				.menssagem("Efetuado o reset da senha do funcionario para 1234");
	}

	public String trocaSenhaPadrao() {
		funcionario = usuario.getUsuario();
		if (novaSenha.equals("1234")) {
			ResetSenhaBean
					.menssagem("Essa senha não pode ser usada, tente novamente!!!");
		} else {
			funcionario.setSenha(novaSenha);
			new DAO<Funcionario>(Funcionario.class).atualiza(funcionario);
			ResetSenhaBean.menssagem("Cadastrado nova senha com sucesso!!!");
			this.novaSenha = "";
			return login.efetuaLogout();
		}
		return "";
	}

	public static void menssagem(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"AVISO", mensagem);
		RequestContext.getCurrentInstance().showMessageInDialog(msg);
	}

}
