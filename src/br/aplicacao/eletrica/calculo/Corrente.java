package br.aplicacao.eletrica.calculo;

public class Corrente {

	public Corrente() {

	}

	public double valor(double potenciaAparente, double tensao, double rendimento) {

		return potenciaAparente / (tensao * rendimento);

	}

	public double valor(double potenciaAtiva, double tensao, double fp, double rendimento) {

		return potenciaAtiva / (tensao * fp * rendimento);

	}

	public double valorReativo(double potenciaReativa, double tensao, double fp, double rendimento) {

		return potenciaReativa / (tensao * fp * rendimento);

	}
}
