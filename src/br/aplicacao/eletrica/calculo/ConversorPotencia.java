package br.aplicacao.eletrica.calculo;

import br.aplicacao.eletrica.enums.UnidadePontencia;

public class ConversorPotencia {

	private Double fatorPotencia;
	private Double potencia;
	private UnidadePontencia unidadeDestino;
	private UnidadePontencia unidadeOrigem;
	private final Double WATT_BTU = 0.29307107;
	private final Double WATT_CV = 735.499;
	private final Double WATT_HP = 745.699872;

	public ConversorPotencia() {

	}

	public Double converte() {

		if (unidadeOrigem == unidadeDestino) {
			return potencia;
		}

		if (unidadeOrigem == UnidadePontencia.W && unidadeDestino == UnidadePontencia.CV) {
			return potencia / WATT_CV;
		}
		if (unidadeOrigem == UnidadePontencia.CV && unidadeDestino == UnidadePontencia.W) {
			return potencia * WATT_CV;
		}
		if (unidadeOrigem == UnidadePontencia.BTU && unidadeDestino == UnidadePontencia.W) {
			return potencia * WATT_BTU;
		}
		if (unidadeOrigem == UnidadePontencia.W && unidadeDestino == UnidadePontencia.BTU) {
			return potencia / WATT_BTU;
		}
		if (unidadeOrigem == UnidadePontencia.HP && unidadeDestino == UnidadePontencia.W) {
			return potencia * WATT_HP;
		}
		if (unidadeOrigem == UnidadePontencia.W && unidadeDestino == UnidadePontencia.HP) {
			return potencia / WATT_HP;
		}
		if (unidadeOrigem == UnidadePontencia.W && unidadeDestino == UnidadePontencia.VA) {
			return potencia / fatorPotencia;
		}
		if (unidadeOrigem == UnidadePontencia.BTU && unidadeDestino == UnidadePontencia.VA) {
			return potencia * WATT_BTU / fatorPotencia;
		}
		if (unidadeOrigem == UnidadePontencia.CV && unidadeDestino == UnidadePontencia.VA) {
			return potencia * WATT_CV / fatorPotencia;
		}
		if (unidadeOrigem == UnidadePontencia.HP && unidadeDestino == UnidadePontencia.VA) {
			return potencia * WATT_HP / fatorPotencia;
		}

		throw new RuntimeException(
				"Nao foi possivel converter a potencia de " + unidadeOrigem + " para " + unidadeDestino);
	}

	public ConversorPotencia withFatorPotencia(Double fatorPotencia) {
		this.fatorPotencia = fatorPotencia;
		return this;
	}

	public ConversorPotencia withPotencia(Double potencia) {
		this.potencia = potencia;
		return this;
	}

	public ConversorPotencia withUnidadeDestino(UnidadePontencia unidadeDestino) {
		this.unidadeDestino = unidadeDestino;
		return this;
	}

	public ConversorPotencia withUnidadeOrigem(UnidadePontencia unidadeOrigem) {
		this.unidadeOrigem = unidadeOrigem;
		return this;
	}

}
