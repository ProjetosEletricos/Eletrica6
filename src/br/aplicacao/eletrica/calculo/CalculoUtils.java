package br.aplicacao.eletrica.calculo;

import br.aplicacao.eletrica.enums.UnidadePontencia;
import br.aplicacao.eletrica.modelo.Fonte;

public class CalculoUtils {

	public enum MODELO_INSTALACAO {
		INDUSTRIAL, PREDIAL
	}

	private Fonte fonte;
	@SuppressWarnings("unused")
	private MODELO_INSTALACAO modelo;

	public CalculoUtils() {

	}

	public CalculoUtils comFonte(Fonte f) {
		this.fonte = f;
		return this;
	}

	public CalculoUtils comModelo(MODELO_INSTALACAO m) {
		this.modelo = m;
		return this;
	}

	public double getDemanda(UnidadePontencia UnidadeDestino) {

		return fonte.getDemanda(UnidadeDestino);
	}

	public Double getPotenciaInstalada(UnidadePontencia UnidadeDestino) {

		return fonte.getPotenciaInstalada(UnidadeDestino);
	}

}
