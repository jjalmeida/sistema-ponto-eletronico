package br.com.ponto.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import br.com.ponto.dao.FuncionarioDao;
import br.com.ponto.dao.MarcaPontoDao;
import br.com.ponto.entity.Funcionario;
import br.com.ponto.entity.MarcaPonto;
import br.com.ponto.entity.TeamLeader;
import br.com.ponto.login.MenuBean;
import br.com.ponto.login.UsuarioLogadoBean;

@ManagedBean
@SessionScoped
public class PontoConsultaBean {
	@Inject
	private UsuarioLogadoBean usuario;
	
	@Inject
	private MenuBean menu;
	
	private FuncionarioDao daoFuncionario = new FuncionarioDao();

	private int idTLeader;

	private Funcionario funcionario;

	private List<Funcionario> listaFuncionario;

	private MarcaPonto ponto;

	private List<MarcaPonto> listaPonto;
	

	public void setIdTLeader(int idTLeader) {
		this.idTLeader = idTLeader;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public MarcaPonto getPonto() {
		return ponto;
	}

	public List<MarcaPonto> getListaPonto() {
		listaPonto = new MarcaPontoDao().getPontoCorrente(funcionario);
		return listaPonto;
	}

	public List<Funcionario> getListaFuncionario() {
		TeamLeader tLeader = usuario.getUsuario().getTeamLeader();
		listaFuncionario = daoFuncionario.listaFuncionarios(tLeader);
		return listaFuncionario;
	}

	public String carregaFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
		return menu.paginaPontoConsultaGestores();
	}

	public void carregaFuncionarioPorTLeader() {
		listaFuncionario = new FuncionarioDao().getFuncionarioPorTeamLeader(this.idTLeader);
	}

	public void getFuncionarioId() {
		this.funcionario = daoFuncionario.buscaPorId(this.funcionario.getId());
	}

}
