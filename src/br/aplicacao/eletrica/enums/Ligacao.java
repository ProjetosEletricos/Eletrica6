package br.aplicacao.eletrica.enums;

public enum Ligacao {

	FFF("FFF"), FFFN("FFFN"), FN("FN"), FF("FF"), FFN("FFN");

	private String sigla;

	private Ligacao(String sigla) {
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}
}
