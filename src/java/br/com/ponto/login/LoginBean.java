package br.com.ponto.login;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.ponto.dao.FuncionarioDao;
import br.com.ponto.entity.Funcionario;

@ManagedBean
@RequestScoped
public class LoginBean {

	private Funcionario funcionario = new Funcionario();

	private FuncionarioDao dao = new FuncionarioDao();

	@Inject
	UsuarioLogadoBean usuarioLogado;

	MenuBean menu = new MenuBean();

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public String efetuaLogin() {

		Funcionario usuarioEncontrado = this.dao.getFuncionario(funcionario
				.getEmployeeId());

		if (usuarioEncontrado != null && possuiMesmaSenha(usuarioEncontrado)) {

			usuarioLogado.logar(usuarioEncontrado);
			
			if (usuarioEncontrado.getSenha().equals("1234")) {
				return "/reset-senha-padrao?faces-redirect=true";
			} else {

				if (usuarioEncontrado.getPerfil().getId() != 1) {

					return menu.paginaFuncionarios();
				} else {

					return menu.paginaAnalistaPonto();
				}
			}
		}

		criaMensagem("Usuário não encontrado!");
		limparForm();

		return "";
	}

	public String efetuaLogout() {
		this.usuarioLogado.deslogar();
		return this.menu.paginaLogin();
	}

	private void limparForm() {
		this.funcionario = new Funcionario();
	}

	private void criaMensagem(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, ""));
	}

	private boolean possuiMesmaSenha(Funcionario usuarioEncontrado) {
		return usuarioEncontrado.getSenha().equals(funcionario.getSenha());
	}
}
