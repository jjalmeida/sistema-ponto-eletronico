package br.com.ponto.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.ponto.dao.MarcaPontoDao;
import br.com.ponto.entity.Funcionario;
import br.com.ponto.entity.MarcaPonto;

/**
 * Classe responsavel por validar e marcar o ponto
 * 
 * @author jojalmeida
 *
 */

public class MarcaPontoControl {

	String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	/**
	 * Construtor pega hora atual do sistema e converte no formato yyyy-MM-dd
	 * para facilitar a busca no Banco de Dados
	 */
	public MarcaPontoControl() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		this.data = sdf.format(Calendar.getInstance().getTime());
	}

	/**
	 * Função recebe um funcionario, valida os horarios marcados e grava novo
	 * horario no Banco de Dados
	 * 
	 * @param funcionario
	 */
	public void marcarPonto(Funcionario funcionario) {
		List<MarcaPonto> validaPonto = new MarcaPontoDao().getPontoData(
				this.data, funcionario);
		MarcaPonto ponto;

		if (validaPonto.isEmpty()) {
			ponto = new MarcaPonto();
			ponto.setFuncionario(funcionario);
			ponto.setData(Calendar.getInstance().getTime());
			ponto.setEntradaManha(Calendar.getInstance().getTime());
			new MarcaPontoDao().marcaPonto(ponto);
		} else {
			if (validaPonto.get(0).getSaidaManha() == null) {
				ponto = validaPonto.get(0);
				ponto.setSaidaManha(Calendar.getInstance().getTime());
				new MarcaPontoDao().atualizaPonto(ponto);
			} else {
				if (validaPonto.get(0).getEntradaTarde() == null) {
					ponto = validaPonto.get(0);
					ponto.setEntradaTarde(Calendar.getInstance().getTime());
					new MarcaPontoDao().atualizaPonto(ponto);
				} else {
					if (validaPonto.get(0).getSaidaTarde() == null) {
						ponto = validaPonto.get(0);
						ponto.setSaidaTarde(Calendar.getInstance().getTime());
						new MarcaPontoDao().atualizaPonto(ponto);
					} else {
						System.out.println("Nada mais por hoje");
					}
				}
			}
		}
	}
}
