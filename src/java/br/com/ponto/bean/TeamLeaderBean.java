package br.com.ponto.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ponto.dao.DAO;
import br.com.ponto.entity.TeamLeader;

@ManagedBean
@SessionScoped
public class TeamLeaderBean {
	
	private DAO<TeamLeader> dao = new DAO<TeamLeader>(TeamLeader.class);
	
	private TeamLeader teamLeader = new TeamLeader();

	public TeamLeader getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(TeamLeader teamLeader) {
		this.teamLeader = teamLeader;
	}
	
	public List<TeamLeader> listaTeamLeader(){
		return dao.listaTodos();
	}
	

}
