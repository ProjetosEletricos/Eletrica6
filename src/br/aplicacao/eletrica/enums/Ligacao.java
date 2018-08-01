package br.aplicacao.eletrica.enums;

public enum Ligacao {

	TRIFASICO_FFF("FFF"), TRIFASICO_FFFN("FFFN"), MONOFASICO_FN("FN"), BIFASICO_FF("FF"), BIFASICO_FFN("FFN");

	private String sigla;

	private Ligacao(String sigla) {
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}
}
