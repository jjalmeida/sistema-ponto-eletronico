package br.com.ponto.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.ponto.dao.MarcaPontoDao;
import br.com.ponto.entity.MarcaPonto;
import br.com.ponto.entity.TeamLeader;
import br.com.ponto.login.UsuarioLogadoBean;

@ManagedBean
@ViewScoped
public class PontoAdminViewBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	UsuarioLogadoBean usuario;
	
	private MarcaPontoDao dao = new MarcaPontoDao();

	private Date dataInicio;

	private Date dataFim;

	private MarcaPonto ponto;

	private List<MarcaPonto> listaPonto;

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public MarcaPonto getPonto() {
		return ponto;
	}

	public List<MarcaPonto> getListaPonto() {
		return listaPonto;
	}
	
	public void pontoDiario() {
		TeamLeader tLeader = usuario.getUsuario().getTeamLeader(); 
		listaPonto = dao.getPontoDataIntervalo(dataInicio, dataFim,tLeader);
	}

}
