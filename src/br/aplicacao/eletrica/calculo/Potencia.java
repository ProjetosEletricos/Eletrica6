package br.aplicacao.eletrica.calculo;

public class Potencia {

	
	private double corrente;
	private double tensao;
	private double Aparente = corrente * tensao;

	public Potencia(double corrente, double tensao) {
		this.corrente = corrente;
		this.tensao = tensao;

	}

	public double Aparente() {
		return Aparente;
	}

	public double Ativa(double Fp) {
		return this.Aparente * Fp;

	}

	public double Reativa(double FpReativo) {
		return this.Aparente * FpReativo;
	}

}