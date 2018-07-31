package br.aplicacao.eletrica.modelo.projeto;

public interface Entidade<T extends Entidade<T>> {

	T clonarSemID();

	T copiar();
	
	void apagar();

	Integer getId();
	

}
