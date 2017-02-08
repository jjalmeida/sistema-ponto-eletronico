package br.com.ponto.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.ponto.dao.DAO;
import br.com.ponto.dao.FuncionarioDao;
import br.com.ponto.entity.Escala;
import br.com.ponto.entity.Funcionario;
import br.com.ponto.entity.Gestor;
import br.com.ponto.entity.Perfil;
import br.com.ponto.entity.Site;
import br.com.ponto.entity.Status;
import br.com.ponto.entity.TeamLeader;
import br.com.ponto.login.MenuBean;
import br.com.ponto.login.UsuarioLogadoBean;

@ManagedBean
public class FuncionarioBean {
	
	@Inject
	UsuarioLogadoBean usuario;

	private Funcionario funcionario = new Funcionario();

	private List<Funcionario> filterFuncionario;

	private List<Funcionario> listaFuncionario;

	private int idEscala, idSite, idGestor, idStatus, idPerfil, idTeamLeader;

	public int getIdTeamLeader() {
		return idTeamLeader;
	}

	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}

	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		TeamLeader tLeader =  usuario.getUsuario().getTeamLeader();
		this.listaFuncionario = new FuncionarioDao().listaFuncionarios(tLeader);
	}

	public void setIdTeamLeader(int idTeamLeader) {
		this.idTeamLeader = idTeamLeader;
	}

	public int getIdEscala() {
		return idEscala;
	}

	public void setIdEscala(int idEscala) {
		this.idEscala = idEscala;
	}

	public int getIdSite() {
		return idSite;
	}

	public void setIdSite(int idSite) {
		this.idSite = idSite;
	}

	public int getIdGestor() {
		return idGestor;
	}

	public void setIdGestor(int idGestor) {
		this.idGestor = idGestor;
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFilterFuncionario() {
		return filterFuncionario;
	}

	public void setFilterFuncionario(List<Funcionario> filterFuncionario) {
		this.filterFuncionario = filterFuncionario;
	}

	public String gravaFuncionario() {

		this.funcionario.setEscala(new DAO<Escala>(Escala.class)
				.buscaPorId(idEscala));
		this.funcionario.setSite(new DAO<Site>(Site.class).buscaPorId(idSite));
		this.funcionario.setGestor(new DAO<Gestor>(Gestor.class)
				.buscaPorId(idGestor));
		this.funcionario.setStatus(new DAO<Status>(Status.class)
				.buscaPorId(idStatus));
		this.funcionario.setPerfil(new DAO<Perfil>(Perfil.class)
				.buscaPorId(idPerfil));
		this.funcionario.setTeamLeader(new DAO<TeamLeader>(TeamLeader.class)
				.buscaPorId(idTeamLeader));
		this.funcionario.setSenha("1234");

		new DAO<Funcionario>(Funcionario.class).adiciona(this.funcionario);

		this.funcionario = new Funcionario();

		return "/gestor/funcionario?faces-redirect=true";

	}

	public String telaCadastroFuncionario() {
		return new MenuBean().paginaCadastroFuncionario();
	}

}
