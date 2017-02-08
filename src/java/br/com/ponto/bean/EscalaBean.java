package br.com.ponto.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.ponto.dao.DAO;
import br.com.ponto.entity.Escala;

@ManagedBean
@RequestScoped
public class EscalaBean {
	
	private DAO<Escala> dao = new DAO<Escala>(Escala.class);

	private Escala escala = new Escala();

	public Escala getEscala() {
		return escala;
	}

	public void setEscala(Escala escala) {
		this.escala = escala;
	}

	public List<Escala> getListaEscala() {
		return dao.listaTodos();
	}
	
	public void novaEscala(){
		dao.adiciona(this.escala);
		this.escala = new Escala();
	}
	
	public void removeEscala(Escala escala){
		dao.remove(escala);
	}
}
