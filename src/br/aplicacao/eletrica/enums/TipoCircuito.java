package br.aplicacao.eletrica.enums;

public enum TipoCircuito {

	BIFASICO("2"), MONOFASICO("1"), TRIFASICO("3");

	private String sigla;

	private TipoCircuito(String sigla) {
		this.sigla = sigla;
	}

	public int getSigla() {
		return Integer.parseInt(sigla);
	}
}
