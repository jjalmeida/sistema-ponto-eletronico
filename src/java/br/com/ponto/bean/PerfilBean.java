package br.com.ponto.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.ponto.dao.DAO;
import br.com.ponto.entity.Perfil;

@ManagedBean
@RequestScoped
public class PerfilBean {

	private DAO<Perfil> dao = new DAO<Perfil>(Perfil.class);
	
	private Perfil perfil = new Perfil();

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Perfil> getListaPerfil() {
		return dao.listaTodos();
	}

}
