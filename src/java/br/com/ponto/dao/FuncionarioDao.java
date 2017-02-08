package br.com.ponto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.ponto.entity.Funcionario;
import br.com.ponto.entity.TeamLeader;

public class FuncionarioDao {

	public List<Funcionario> listaFuncionarios(TeamLeader tLeader) {
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Funcionario> query = em.createQuery("FROM Funcionario f WHERE f.teamLeader = :pTLeader AND f.perfil = 1 AND f.status = 1 ORDER BY f.nome",Funcionario.class);

		query.setParameter("pTLeader", tLeader);
		
		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

		listaFuncionarios = query.getResultList();
		
		em.close();

		return listaFuncionarios;
	}

	public Funcionario getFuncionario(String employee) {
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Funcionario> query = em.createQuery("FROM Funcionario f WHERE f.employeeId = :pEmployeeId",Funcionario.class);

		query.setParameter("pEmployeeId", employee);

		Funcionario funcionario =query.getSingleResult();

		em.close();
		
		return funcionario;
	}
	
	public List<Funcionario> getFuncionarioPorTeamLeader(long idTLeader) {
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Funcionario> query = em
				.createQuery("FROM Funcionario f WHERE f.teamLeader = :pIdTLeader AND f.perfil = 1 AND f.status = 1 ORDER BY f.nome", Funcionario.class);
		query.setParameter("pIdTLeader", idTLeader);
		
		List<Funcionario> listFuncionario = query.getResultList();
		
		em.close();

		return listFuncionario;
	}

	public Funcionario buscaPorId(long id) {
		EntityManager em = new JPAUtil().getEntityManager();
		Funcionario funcionario = em.find(Funcionario.class, id);
		em.close();
		return funcionario;
	}


}
