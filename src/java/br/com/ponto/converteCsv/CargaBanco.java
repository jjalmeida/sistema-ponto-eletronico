package br.com.ponto.converteCsv;

import java.util.List;

import br.com.ponto.dao.DAO;
import br.com.ponto.entity.Funcionario;

public class CargaBanco {

	public static void main(String[] args) {

		CarregaArquivo lf = new CarregaArquivo();

		List<Funcionario> funcs = lf.carregaArquivoCsv();

		for (Funcionario func : funcs) {
			new DAO<Funcionario>(Funcionario.class).adiciona(func);			
		}

	}
}
