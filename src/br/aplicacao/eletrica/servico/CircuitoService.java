package br.aplicacao.eletrica.servico;

import java.util.List;

import br.aplicacao.eletrica.dao.JpaDAO;
import br.aplicacao.eletrica.modelo.projeto.Circuito;

public class CircuitoService {

	private final static JpaDAO<Circuito> DAO_CIRCUITO = new JpaDAO<Circuito>(Circuito.class);

	public static List<Circuito> getAll() {
		List<Circuito> lista = DAO_CIRCUITO.getAll();
		return lista;
	}

	public static List<Circuito> getByExpres(String expres, Object[] parameter) {

		return DAO_CIRCUITO.getByExpres(expres, parameter);
	}

	public static Circuito getById(Integer id) {

		return DAO_CIRCUITO.getById(id);
	}

	public static void remove(Circuito circuito) {

		DAO_CIRCUITO.remove(circuito);
	}

	public static void removeById(Integer id) {

		DAO_CIRCUITO.removeById(id);
	}

	public static void salve(Circuito circuito) {

		DAO_CIRCUITO.salva(circuito);
	}

	public static void atualiza(Circuito circuito) {

		DAO_CIRCUITO.atualiza(circuito);
	}

}
