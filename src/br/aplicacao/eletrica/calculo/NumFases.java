package br.aplicacao.eletrica.calculo;

import br.aplicacao.eletrica.enums.Ligacao;

public class NumFases {
	private Ligacao ligacao;

	public NumFases() {
		
	}
	
	public Integer numero() {
		int valor = 0;
		
		if (this.ligacao == Ligacao.FN) {
			valor = 1;
		}
		if (this.ligacao == Ligacao.FF || this.ligacao == Ligacao.FFN) {
			valor = 2;
		}
		if (this.ligacao == Ligacao.FFF || this.ligacao == Ligacao.FFFN) {
			valor = 3;
		}
		return valor;
	}
	
	public NumFases withLigacao(Ligacao ligacao) {
		this.ligacao = ligacao;
		return this;
	}
}
