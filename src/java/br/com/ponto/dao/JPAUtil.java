package br.com.ponto.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ponto_hp");
	
	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	public void close(EntityManager em){
		em.close();
	}
	
	public void closeFactory(){
		emf.close();
	}

}
