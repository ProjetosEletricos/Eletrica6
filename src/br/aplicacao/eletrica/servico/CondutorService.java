package br.aplicacao.eletrica.servico;

import java.util.List;

import br.aplicacao.eletrica.dao.JpaDAO;
import br.aplicacao.eletrica.modelo.projeto.Condutor;

public class CondutorService {

	private final static JpaDAO<Condutor> DAO_CONDUTOR = new JpaDAO<Condutor>(Condutor.class);

	public static List<Condutor> getAll() {
		List<Condutor> lista = DAO_CONDUTOR.getAll();
		return lista;
	}

	public static List<Condutor> getByExpres(String expres, Object[] parameter) {

		return DAO_CONDUTOR.getByExpres(expres, parameter);
	}

	public static Condutor getById(Integer id) {

		return DAO_CONDUTOR.getById(id);
	}

	public static void remove(Condutor Condutor) {

		DAO_CONDUTOR.remove(Condutor);
	}

	public static void removeById(Integer id) {

		DAO_CONDUTOR.removeById(id);
	}

	public static void salva(Condutor Condutor) {

		DAO_CONDUTOR.salva(Condutor);
	}


}
