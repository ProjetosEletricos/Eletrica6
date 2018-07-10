package br.aplicacao.eletrica.enums;

public enum UnidadePontencia {

	BTU("BTU"), CV("CV"), HP("HP"), VA("VA"), W("W");

	private String sigla;

	private UnidadePontencia(String sigla) {
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}
}
