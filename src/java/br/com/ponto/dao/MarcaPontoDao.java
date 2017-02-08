package br.com.ponto.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import br.com.ponto.entity.Funcionario;
import br.com.ponto.entity.MarcaPonto;
import br.com.ponto.entity.TeamLeader;

public class MarcaPontoDao {

	public void marcaPonto(MarcaPonto ponto) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(ponto);
		em.getTransaction().commit();
		em.close();
	}

	public void atualizaPonto(MarcaPonto ponto) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.merge(ponto);
		em.getTransaction().commit();
		em.close();
	}

	public List<MarcaPonto> getPontoData(String data, Funcionario id) {
		EntityManager em = new JPAUtil().getEntityManager();
		Query query = em.createQuery("SELECT c FROM MarcaPonto c "
				+ "WHERE c.data = '" + data + "' AND c.funcionario = :id");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<MarcaPonto> ponto = query.getResultList();

		em.close();
		return ponto;
	}

	/*
	public List<MarcaPonto> getPontoCorrente(Funcionario funcionario) {
		EntityManager em = new JPAUtil().getEntityManager();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dataInicio = getDataInicio(format);
		Date dataFim = getDataFim(format);

		TypedQuery<MarcaPonto> query = em
				.createQuery(
						"FROM MarcaPonto m WHERE (m.data BETWEEN :pDataInicio AND :pDataFim) AND m.funcionario = :pFuncionario",
						MarcaPonto.class);
		query.setParameter("pDataInicio", dataInicio, TemporalType.DATE)
				.setParameter("pDataFim", dataFim, TemporalType.DATE)
				.setParameter("pFuncionario", funcionario);

		List<MarcaPonto> listaPonto = query.getResultList();

		em.close();

		return listaPonto;
	}
*/
	public List<MarcaPonto> getPontoCorrente(Funcionario funcionario) {
		EntityManager em = new JPAUtil().getEntityManager();
		Calendar data = Calendar.getInstance();
		int mesInicio;
		int mesFim;
		int anoInicio;
		int anoFim;
		Date dataInicio;
		Date dataFim;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (data.get(Calendar.DAY_OF_MONTH) >= 16) {
				if (data.get(Calendar.MONTH) == 11) {
					System.out.println("== 1");
					mesInicio = data.get(Calendar.MONTH) + 1;
					mesFim = 1;
					anoInicio = data.get(Calendar.YEAR);
					anoFim = data.get(Calendar.YEAR) + 1;
				} else {
					System.out.println("== 2");
					mesInicio = data.get(Calendar.MONTH) + 1;
					mesFim = data.get(Calendar.MONTH) + 2;
					anoInicio = data.get(Calendar.YEAR);
					anoFim = data.get(Calendar.YEAR);
				}
				dataInicio = format.parse("" + anoInicio + "-"
						+ mesInicio + "-16");
				dataFim = format.parse("" + anoFim + "-" + mesFim
						+ "-15");
			} else {
				if (data.get(Calendar.MONTH) == 0) {
					System.out.println("== 3");
					mesInicio = 12;
					mesFim = data.get(Calendar.MONTH) + 1;
					anoInicio = data.get(Calendar.YEAR) - 1;
					anoFim = data.get(Calendar.YEAR);
				} else {
					System.out.println("== 4");
					mesInicio = data.get(Calendar.MONTH);
					mesFim = data.get(Calendar.MONTH) + 1;
					anoInicio = data.get(Calendar.YEAR);
					anoFim = data.get(Calendar.YEAR);
				}
				dataInicio = format.parse("" + anoInicio + "-"
						+ mesInicio + "-16");
				dataFim = format.parse("" + anoFim + "-" + mesFim
						+ "-15");
			}

			TypedQuery<MarcaPonto> query = em
					.createQuery(
							"FROM MarcaPonto m WHERE (m.data BETWEEN :pDataInicio AND :pDataFim) AND m.funcionario = :pFuncionario",
							MarcaPonto.class);
			query.setParameter("pDataInicio", dataInicio, TemporalType.DATE)
					.setParameter("pDataFim", dataFim, TemporalType.DATE)
					.setParameter("pFuncionario", funcionario);

			List<MarcaPonto> ponto = query.getResultList();			

			return ponto;
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	private Date getDataFim(DateFormat format) {
		Calendar data = Calendar.getInstance();
		Date dataFim;
		try {
			if (data.get(Calendar.DAY_OF_MONTH) >= 16) {
				dataFim = format.parse("" + data.get(Calendar.YEAR) + "-"
						+ (data.get(Calendar.MONTH) + 2) + "-15");
			} else {
				dataFim = format.parse("" + data.get(Calendar.YEAR) + "-"
						+ (data.get(Calendar.MONTH) + 1) + "-15");
			}
			return dataFim;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Date getDataInicio(DateFormat format) {
		Calendar data = Calendar.getInstance();
		Date dataInicio;

		try {
			if (data.get(Calendar.DAY_OF_MONTH) >= 16) {
				dataInicio = format.parse("" + data.get(Calendar.YEAR) + "-"
						+ (data.get(Calendar.MONTH) + 1) + "-16");
			} else {
				dataInicio = format.parse("" + data.get(Calendar.YEAR) + "-"
						+ data.get(Calendar.MONTH) + "-16");
			}
			return dataInicio;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
*/
	
	public List<MarcaPonto> getPontoDataIntervalo(Date dataInicio,
			Date dataFim, TeamLeader tLeader) {
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<MarcaPonto> query = em
				.createQuery(
						"SELECT m FROM MarcaPonto m JOIN m.funcionario f WHERE m.data BETWEEN :pDataInicio AND :pDataFim AND f.teamLeader = :pTLeader ORDER BY m.data, m.entradaManha",
						MarcaPonto.class);
		query.setParameter("pDataInicio", dataInicio, TemporalType.DATE)
				.setParameter("pDataFim", dataFim, TemporalType.DATE)
				.setParameter("pTLeader", tLeader);

		List<MarcaPonto> ponto = query.getResultList();

		em.close();

		return ponto;
	}

	public List<MarcaPonto> getPontoInvervaloPorUsuario(Date dataInicio,
			Date dataFim, Funcionario idFuncionario) {
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<MarcaPonto> query = em
				.createQuery(
						"FROM MarcaPonto m WHERE m.funcionario = :pIdFuncionario and m.data BETWEEN :pDataInicio AND :pDataFim",
						MarcaPonto.class);
		query.setParameter("pIdFuncionario", idFuncionario);
		query.setParameter("pDataInicio", dataInicio, TemporalType.DATE);
		query.setParameter("pDataFim", dataFim, TemporalType.DATE);

		List<MarcaPonto> ponto = query.getResultList();

		em.close();

		return ponto;
	}

}
