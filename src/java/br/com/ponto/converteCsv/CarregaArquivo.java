package br.com.ponto.converteCsv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ponto.dao.DAO;
import br.com.ponto.entity.Escala;
import br.com.ponto.entity.Funcionario;
import br.com.ponto.entity.Gestor;
import br.com.ponto.entity.Perfil;
import br.com.ponto.entity.Site;
import br.com.ponto.entity.Status;

public class CarregaArquivo {

	public List<Funcionario> carregaArquivoCsv() {

		String csvFileToRead = "/worskpace/ponto/funcionarios_wt.csv";

		BufferedReader br = null;
		String linha = "";
		String splitBy = ";";
		String[] lista = null;
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		

		try {
			
			br = new BufferedReader(new FileReader(csvFileToRead));
			br.readLine();
			while ((linha = br.readLine()) != null) {
				lista = linha.split(splitBy);
				
				Funcionario lf = new Funcionario();
				lf.setNome(lista[0]);
				lf.setCpf(lista[1]);
				lf.setEmployeeId(lista[2]);
				lf.setSite(new DAO<Site>(Site.class).buscaPorId(Long.parseLong(lista[3])));
				lf.setGestor(new DAO<Gestor>(Gestor.class).buscaPorId(Long.parseLong(lista[4])));
				lf.setEscala(new DAO<Escala>(Escala.class).buscaPorId(Long.parseLong(lista[5])));
				lf.setStatus(new DAO<Status>(Status.class).buscaPorId(Long.parseLong(lista[6])));
				lf.setSenha(lista[7]);
				lf.setPerfil(new DAO<Perfil>(Perfil.class).buscaPorId(Long.parseLong(lista[8])));
				
				funcionarios.add(lf);
				
			}
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return funcionarios;
	}

}
