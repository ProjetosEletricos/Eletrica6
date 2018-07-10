package br.aplicacao.eletrica.calculo;

import br.aplicacao.eletrica.modelo.projeto.Projeto;

public class PotenciaInstalada {

	private Projeto projeto;
	private double total;

	public PotenciaInstalada(Projeto projeto) {
		this.projeto = projeto;
	}

	public void add(double potW) {
		total += potW;
	}

	public void calculo() {
	}

	public double getTotal() {
		return total;
	}

}
