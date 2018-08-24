package br.aplicacao.eletrica.modelo;

public interface Entidade<T extends Entidade<T>> {

	T clonarSemID();

	T copiar();
	
	void apagar();

	Integer getId();
	

}
