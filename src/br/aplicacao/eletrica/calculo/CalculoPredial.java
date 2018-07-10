package br.aplicacao.eletrica.calculo;

import br.aplicacao.eletrica.modelo.projeto.Projeto;

public class CalculoPredial {

	private double demanda;
	private double fd;
	private double potenciaInstalada;
	private Projeto projeto;

	public CalculoPredial(Projeto projeto) {

		this.projeto = projeto;

	}
}
