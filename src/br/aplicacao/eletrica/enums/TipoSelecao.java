package br.aplicacao.eletrica.enums;

public enum TipoSelecao {

	ABRIR("ABRIR"), SALVAR("SALVAR");

	private String sigla;

	private TipoSelecao(String sigla) {
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}
}
