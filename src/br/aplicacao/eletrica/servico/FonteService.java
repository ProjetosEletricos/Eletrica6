package br.aplicacao.eletrica.servico;

import java.util.List;

import br.aplicacao.eletrica.dao.JpaDAO;
import br.aplicacao.eletrica.modelo.projeto.Fonte;

public class FonteService {

	private final static JpaDAO<Fonte> DAO_FONTE = new JpaDAO<Fonte>(Fonte.class);

	public static List<Fonte> getAll() {
		List<Fonte> lista = DAO_FONTE.getAll();
		return lista;
	}

	public static List<Fonte> getByExpres(String expres, Object[] parameter) {

		return DAO_FONTE.getByExpres(expres, parameter);
	}

	public static Fonte getById(Integer id) {

		return DAO_FONTE.getById(id);
	}

	public static void remove(Fonte fonte) {

		DAO_FONTE.remove(fonte);
	}

	public static void removeById(Integer id) {

		DAO_FONTE.removeById(id);
	}

	public static void salva(Fonte fonte) {

		DAO_FONTE.salva(fonte);
	}
	


}
