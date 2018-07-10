package br.aplicacao.eletrica.calculo;

import br.aplicacao.eletrica.modelo.projeto.Fonte;
import br.aplicacao.eletrica.modelo.projeto.Projeto;

public class CalculoUtils {

	public enum MODELO_INSTALACAO {
		INDUSTRIAL, PREDIAL
	}

	private Fonte fonte;
	@SuppressWarnings("unused")
	private MODELO_INSTALACAO modelo;
	private Projeto projeto;

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

	public CalculoUtils comProjeto(Projeto p) {
		this.projeto = p;
		return this;
	}

	public double getDemanda() {

		return fonte.getDemanda();

	}

	public Double getPotenciaInstalada() {

		return fonte.getPotenciaInstalada();
	}

}
