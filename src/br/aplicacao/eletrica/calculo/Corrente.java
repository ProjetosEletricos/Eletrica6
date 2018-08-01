package br.aplicacao.eletrica.calculo;

import br.aplicacao.eletrica.enums.Ligacao;
import br.aplicacao.eletrica.enums.UnidadePontencia;

public class Corrente {

	private Ligacao ligacao;
	private Double potencia;
	private Double tensaoFN;
	private UnidadePontencia unidade;
	private Double fp;

	public Corrente() {

	}

	public Double valor() {
		double valor = 0;

		if (ligacao == Ligacao.FFF || ligacao == Ligacao.FFFN) {
			valor = getPotenciaEmVA() / (Math.sqrt(3) * tensaoFN);
		}
		if (ligacao == Ligacao.FF || ligacao == Ligacao.FFN) {
			valor = getPotenciaEmVA() / (tensaoFN);
		}
		if (ligacao == Ligacao.FN) {
			valor = getPotenciaEmVA() / (tensaoFN);
		}
		return valor;
	}

	public Corrente withPotencia(Double potencia) {
		this.potencia = potencia;
		return this;
	}

	public Corrente withLigacao(Ligacao ligacao) {
		this.ligacao = ligacao;
		return this;
	}

	public Corrente withTensao(Double tensaoFN) {
		this.tensaoFN = tensaoFN;
		return this;
	}

	public Corrente withUnidade(UnidadePontencia unidade) {
		this.unidade = unidade;
		return this;
	}

	private Double getPotenciaEmVA() {
		return new ConversorPotencia()//
				.withFatorPotencia(fp)//
				.withPotencia(potencia)//
				.withUnidadeOrigem(unidade)//
				.withUnidadeDestino(UnidadePontencia.VA)//
				.converte();
	}

	@SuppressWarnings("unused")
	private Double getPotenciaEmW() {
		return new ConversorPotencia()//
				.withFatorPotencia(fp)//
				.withPotencia(potencia)//
				.withUnidadeOrigem(unidade)//
				.withUnidadeDestino(UnidadePontencia.W)//
				.converte();
	}
}
