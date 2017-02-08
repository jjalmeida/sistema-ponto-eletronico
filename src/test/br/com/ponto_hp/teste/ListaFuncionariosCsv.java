package br.com.ponto_hp.teste;

import br.com.ponto.converteCsv.CarregaArquivo;
import br.com.ponto.entity.Funcionario;

public class ListaFuncionariosCsv {
	
	public static void main(String[] args) {
		CarregaArquivo ca = new CarregaArquivo();
		for (Funcionario func : ca.carregaArquivoCsv()) {
			System.out.println(func.getNome());
		}
	}

}
