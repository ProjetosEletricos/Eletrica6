package br.aplicacao.eletrica.servico;

import java.util.List;

import br.aplicacao.eletrica.dao.JpaDAO;
import br.aplicacao.eletrica.janelas.tabelas.CapacidadeCorrente;

public class CapacidadeCorrenteService {

	private final static JpaDAO<CapacidadeCorrente> DAO_CAPACIDADE = new JpaDAO<CapacidadeCorrente>(
			CapacidadeCorrente.class);

	public static List<CapacidadeCorrente> getAll() {
		List<CapacidadeCorrente> lista = DAO_CAPACIDADE.getAll();
		return lista;
	}

	public static List<CapacidadeCorrente> getByExpres2(String expres, Object[] parameter) {

		return DAO_CAPACIDADE.getByExpres2(expres, parameter);
	}

	public static CapacidadeCorrente getById(Integer id) {

		return DAO_CAPACIDADE.getById(id);
	}

	public static void remove(CapacidadeCorrente capacidadeCorrente) {

		DAO_CAPACIDADE.remove(capacidadeCorrente);
	}

	public static void removeById(Integer id) {

		DAO_CAPACIDADE.removeById(id);
	}

	public static void salva(CapacidadeCorrente capacidadeCorrente) {

		DAO_CAPACIDADE.salva(capacidadeCorrente);
	}

	public static void limpa() {
		
		DAO_CAPACIDADE.excluirTodos("CapacidadeCorrente");

	}

}
