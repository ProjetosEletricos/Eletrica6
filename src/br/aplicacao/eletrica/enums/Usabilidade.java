package br.aplicacao.eletrica.enums;

public enum Usabilidade {

	ILUMINACAO_INCADESCENTE("ILUMINACAO INCADESCENTE"), ILUMINACAO_FLUORESCENTE("ILUMINACAO FLUORESCENTE"), MOTOR("MOTOR"), GERAL("GERAL");

	private String sigla;

	private Usabilidade(String sigla) {
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}
}
