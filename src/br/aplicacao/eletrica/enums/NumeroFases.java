package br.aplicacao.eletrica.enums;

public enum NumeroFases {

	FF("2"), FN("1"), FFF("3"), FFFN("3"), FFN("2");

	private String sigla;

	private NumeroFases(String sigla) {
		this.sigla = sigla;
	}

	public int getSigla() {
		return Integer.parseInt(sigla);
	}
}
