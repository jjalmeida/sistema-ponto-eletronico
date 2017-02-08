package br.com.ponto_hp.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.ponto.dao.DAO;
import br.com.ponto.dao.MarcaPontoDao;
import br.com.ponto.entity.Escala;
import br.com.ponto.entity.Funcionario;
import br.com.ponto.entity.Gestor;
import br.com.ponto.entity.Justificativa;
import br.com.ponto.entity.MarcaPonto;
import br.com.ponto.entity.Perfil;
import br.com.ponto.entity.Site;
import br.com.ponto.entity.Status;

public class TestaBanco {

	public void adicionaGestor() {
		Gestor gestor = new Gestor();
		gestor.setNome("Gustavo Magalhães de Castro Castilho");

		new DAO<Gestor>(Gestor.class).adiciona(gestor);
	}

	public void adicionaSite() {
		Site site1 = new Site();
		site1.setDescricao("FLFC");
		new DAO<Site>(Site.class).adiciona(site1);

		Site site2 = new Site();
		site2.setDescricao("WTorre");
		new DAO<Site>(Site.class).adiciona(site2);

		Site site3 = new Site();
		site3.setDescricao("FL 3500");
		new DAO<Site>(Site.class).adiciona(site3);

		Site site4 = new Site();
		site4.setDescricao("Icon");
		new DAO<Site>(Site.class).adiciona(site4);
	}

	public void adicionaEscala() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		try {
			Escala escala1 = new Escala();
			escala1.setDescricao("Escala das seis");
			escala1.setEntrada(sdf.parse("06:00:00"));
			escala1.setSaida(sdf.parse("11:00:00"));
			new DAO<Escala>(Escala.class).adiciona(escala1);
			
			Escala escala2 = new Escala();
			escala2.setDescricao("Escala das sete");
			escala2.setEntrada(sdf.parse("07:00:00"));
			escala2.setSaida(sdf.parse("16:00:00"));
			new DAO<Escala>(Escala.class).adiciona(escala2);

			Escala escala3 = new Escala();
			escala3.setDescricao("Escala das oito");
			escala3.setEntrada(sdf.parse("08:00:00"));
			escala3.setSaida(sdf.parse("17:00:00"));
			new DAO<Escala>(Escala.class).adiciona(escala3);

			Escala escala4 = new Escala();
			escala4.setDescricao("Escala das nove");
			escala4.setEntrada(sdf.parse("09:00:00"));
			escala4.setSaida(sdf.parse("18:00:00"));
			new DAO<Escala>(Escala.class).adiciona(escala4);

			Escala escala5 = new Escala();
			escala5.setDescricao("Escala das dez");
			escala5.setEntrada(sdf.parse("10:00:00"));
			escala5.setSaida(sdf.parse("19:00:00"));
			new DAO<Escala>(Escala.class).adiciona(escala5);

			Escala escala6 = new Escala();
			escala6.setDescricao("Escala das onze");
			escala6.setEntrada(sdf.parse("11:00:00"));
			escala6.setSaida(sdf.parse("20:00:00"));
			new DAO<Escala>(Escala.class).adiciona(escala6);
			
			Escala escala7 = new Escala();
			escala7.setDescricao("Escala das doze");
			escala7.setEntrada(sdf.parse("12:00:00"));
			escala7.setSaida(sdf.parse("21:00:00"));
			new DAO<Escala>(Escala.class).adiciona(escala7);
			
			Escala escala8 = new Escala();
			escala8.setDescricao("Escala das treze");
			escala8.setEntrada(sdf.parse("13:00:00"));
			escala8.setSaida(sdf.parse("22:00:00"));
			new DAO<Escala>(Escala.class).adiciona(escala8);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void adicionaStatus(){
		Status status = new Status();
		status.setDescricao("Ativo");
		new DAO<Status>(Status.class).adiciona(status);
		
		Status status1 = new Status();
		status1.setDescricao("Inativo");
		new DAO<Status>(Status.class).adiciona(status1);
	}
	
	public void adicionaFuncionario(){
		
		Site site = new Site();
		site = new DAO<Site>(Site.class).buscaPorId(1);
		
		Gestor gestor = new Gestor();
		gestor = new DAO<Gestor>(Gestor.class).buscaPorId(1);
		
		Status status = new Status();
		status = new DAO<Status>(Status.class).buscaPorId(1);
		
		Escala escala = new Escala();
		escala = new DAO<Escala>(Escala.class).buscaPorId(1);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Alyson de Souza Dias");
		funcionario.setCpf("38181522842");
		funcionario.setEmployeeId("60026975");
		funcionario.setSite(site);
		funcionario.setGestor(gestor);
		funcionario.setStatus(status);
		funcionario.setEscala(escala);
		
		new DAO<Funcionario>(Funcionario.class).adiciona(funcionario);
		
	}
	
	public void adicionaPonto(){
		MarcaPonto ponto = new MarcaPonto();
		Funcionario func = new DAO<Funcionario>(Funcionario.class).buscaPorId(1);
		
		ponto.setData(Calendar.getInstance().getTime());
		ponto.setEntradaManha(Calendar.getInstance().getTime());
		ponto.setFuncionario(func);
		
		new MarcaPontoDao().marcaPonto(ponto);
	}
	
	public void adicionaPerfil(){
		/*
		Perfil perfil1 = new Perfil();
		perfil1.setDescrição("tecnico");
		new DAO<Perfil>(Perfil.class).adiciona(perfil1);
		*/
		Perfil perfil2 = new Perfil();
		perfil2.setDescricao("lider");
		new DAO<Perfil>(Perfil.class).adiciona(perfil2);
	}
	
	public void adicionaJustificativa(){
		Justificativa just1 = new Justificativa();
		just1.setDescricao("Acidente Trabalho");
		new DAO<Justificativa>(Justificativa.class).adiciona(just1);
		
		Justificativa just2 = new Justificativa();
		just2.setDescricao("Amamentação");
		new DAO<Justificativa>(Justificativa.class).adiciona(just2);
		
		Justificativa just3 = new Justificativa();
		just3.setDescricao("Atestado Medico");
		new DAO<Justificativa>(Justificativa.class).adiciona(just3);
		
		Justificativa just4 = new Justificativa();
		just4.setDescricao("Atividade Sindical");
		new DAO<Justificativa>(Justificativa.class).adiciona(just4);
		
		Justificativa just5 = new Justificativa();
		just5.setDescricao("Atraso");
		new DAO<Justificativa>(Justificativa.class).adiciona(just5);
		
		Justificativa just6 = new Justificativa();
		just6.setDescricao("Casamento");
		new DAO<Justificativa>(Justificativa.class).adiciona(just6);
		
		Justificativa just7 = new Justificativa();
		just7.setDescricao("Descanso BH");
		new DAO<Justificativa>(Justificativa.class).adiciona(just7);
		
		Justificativa just8 = new Justificativa();
		just8.setDescricao("Doação de Sangue");
		new DAO<Justificativa>(Justificativa.class).adiciona(just8);
		
		Justificativa just9 = new Justificativa();
		just9.setDescricao("Falec Familiar");
		new DAO<Justificativa>(Justificativa.class).adiciona(just9);
		
		Justificativa just10 = new Justificativa();
		just10.setDescricao("Falta Injustificada");
		new DAO<Justificativa>(Justificativa.class).adiciona(just10);
		
		Justificativa just11 = new Justificativa();
		just11.setDescricao("Licença Educacional");
		new DAO<Justificativa>(Justificativa.class).adiciona(just11);
		
		Justificativa just12 = new Justificativa();
		just12.setDescricao("Licença Eleitoral");
		new DAO<Justificativa>(Justificativa.class).adiciona(just12);
		
		Justificativa just13 = new Justificativa();
		just13.setDescricao("Licença Paternidade");
		new DAO<Justificativa>(Justificativa.class).adiciona(just13);
		
		Justificativa just14 = new Justificativa();
		just14.setDescricao("Licença por Adoção");
		new DAO<Justificativa>(Justificativa.class).adiciona(just14);
		
		Justificativa just15 = new Justificativa();
		just15.setDescricao("Reclusão");
		new DAO<Justificativa>(Justificativa.class).adiciona(just15);
		
		Justificativa just16 = new Justificativa();
		just16.setDescricao("Saida Antecipada");
		new DAO<Justificativa>(Justificativa.class).adiciona(just16);
		
		Justificativa just17 = new Justificativa();
		just17.setDescricao("Serviço Militar");
		new DAO<Justificativa>(Justificativa.class).adiciona(just17);
		
		Justificativa just18 = new Justificativa();
		just18.setDescricao("Suspensão");
		new DAO<Justificativa>(Justificativa.class).adiciona(just18);
		
		Justificativa just19 = new Justificativa();
		just19.setDescricao("À Disposição da Justiça");
		new DAO<Justificativa>(Justificativa.class).adiciona(just19);
		
		Justificativa just20 = new Justificativa();
		just20.setDescricao("Desvio Uso Da Ferramenta");
		new DAO<Justificativa>(Justificativa.class).adiciona(just20);
	}
	
	public static void main(String[] args) {
		// EntityManager em = new JPAUtil().getEntityManager();
		// em.getTransaction().begin();
		// em.close();

		//TestaBanco banco = new TestaBanco();
		//banco.adicionaEscala();
		//banco.adicionaGestor();
		//banco.adicionaJustificativa();
		//banco.adicionaSite();
		//banco.adicionaStatus();
		//banco.adicionaPerfil();
		//banco.adicionaFuncionario();
		//banco.adicionaPonto();
		
		//Funcionario funcionario = new DAO<Funcionario>(Funcionario.class).buscaPorId(3);
		
		//funcionario.setSenha("123");
		
		//new DAO<Funcionario>(Funcionario.class).atualiza(funcionario);
		
		//JPAUtil dao = new JPAUtil();
		//dao.closeFactory();
		/*
		Funcionario funcionario = new DAO<Funcionario>(Funcionario.class).buscaPorId(50);
		List<MarcaPonto> listaPonto = new MarcaPontoDao().getPonto(funcionario);
		for (MarcaPonto p : listaPonto) {
			System.out.println(p.getFuncionario().getNome());
		}
		*/
		Calendar data = Calendar.getInstance();
		//System.out.println(data.get(Calendar.YEAR));
		
		System.out.println("" + (data.get(Calendar.YEAR) - 1) + "-" + data.get(Calendar.MONTH) + "-16");
		System.out.println("" + data.get(Calendar.YEAR) + "-" + (data.get(Calendar.MONTH) + 1) + "-15");
		
		//System.out.println("" + (data.get(Calendar.YEAR) + 1) + "-1" + "-15");
		
	}
}
