package br.aplicacao.eletrica.calculo;

public class Demanda {

	private double total;

	public Demanda() {

	}

	public void add(double potVA, double fd) {
		total += potVA * fd;
	}

	public double getTotal() {
		return total;
	}
}
