package br.com.ponto.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.ponto.dao.DAO;
import br.com.ponto.entity.Status;

@ManagedBean
public class StatusBean {
	
	private DAO<Status> dao = new DAO<Status>(Status.class);
	
	private Status status = new Status();

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Status> getListaStatus() {
		return dao.listaTodos();
	}
	
	public void novoStatus(){
		dao.adiciona(this.status);
		this.status = new Status();
	}
	
}
