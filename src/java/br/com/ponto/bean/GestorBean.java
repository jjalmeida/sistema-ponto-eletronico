package br.com.ponto.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.ponto.dao.DAO;
import br.com.ponto.entity.Gestor;

@ManagedBean
@RequestScoped
public class GestorBean {

	private DAO<Gestor> dao = new DAO<Gestor>(Gestor.class);
	
	private Gestor gestor = new Gestor();
	
	public Gestor getGestor() {
		return gestor;
	}

	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}

	public List<Gestor> getListaGestor() {
		return dao.listaTodos();
	}
	
	public void novoGestor(){
		dao.adiciona(this.gestor);
		this.gestor = new Gestor();
	}
	
}
