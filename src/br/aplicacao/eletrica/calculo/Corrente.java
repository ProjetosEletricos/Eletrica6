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
			try {
				valor = getPotenciaEmVA() / (Math.sqrt(3) * tensaoFN);
			} catch (Exception e) {
				valor = getPotenciaEmW() / (Math.sqrt(3) * tensaoFN * fp);
			}
		}
		if (ligacao == Ligacao.FF || ligacao == Ligacao.FFN) {
			try {
				valor = getPotenciaEmVA() / (tensaoFN);
			} catch (Exception e) {
				valor = getPotenciaEmW() / (tensaoFN * fp);
			}
		}
		if (ligacao == Ligacao.FN) {
			try {
				valor = getPotenciaEmVA() / (tensaoFN);
			} catch (Exception e) {
				valor = getPotenciaEmW() / (tensaoFN * fp);
			}
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
	
	public Corrente withFP(Double fp) {
		this.fp = fp;
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

	private Double getPotenciaEmW() {
		return new ConversorPotencia()//
				.withFatorPotencia(fp)//
				.withPotencia(potencia)//
				.withUnidadeOrigem(unidade)//
				.withUnidadeDestino(UnidadePontencia.W)//
				.converte();
	}
}
