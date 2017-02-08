package br.com.ponto.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.ponto.dao.DAO;
import br.com.ponto.entity.Site;

@ManagedBean
@RequestScoped
public class SiteBean {

	private DAO<Site> dao = new DAO<Site>(Site.class);
	
	private Site site = new Site();

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public List<Site> getListaSite() {
		return dao.listaTodos();
	}
	
	public void novoSite(){
		dao.adiciona(this.site);
		this.site = new Site();
	}
	
	public void removeSite(Site site){
		dao.remove(site);
	}
	
}
