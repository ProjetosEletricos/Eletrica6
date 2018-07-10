package br.aplicacao.eletrica.servico;

import java.util.List;

import br.aplicacao.eletrica.dao.JpaDAO;
import br.aplicacao.eletrica.modelo.projeto.Projeto;

public class ProjetoService {

	private final static JpaDAO<Projeto> DAO_PROJETO = new JpaDAO<Projeto>(Projeto.class);

	public static List<Projeto> getAll() {
		List<Projeto> lista = DAO_PROJETO.getAll();
		return lista;
	}

	public static List<Projeto> getByExpres(String expres, Object[] parameter) {

		return DAO_PROJETO.getByExpres(expres, parameter);
	}

	public static Projeto getById(Integer id) {

		return DAO_PROJETO.getById(id);
	}

	public static void remove(Projeto projeto) {

		DAO_PROJETO.remove(projeto);
	}

	public static void removeById(Integer id) {

		DAO_PROJETO.removeById(id);
	}

	public static void salva(Projeto projeto) {

		DAO_PROJETO.salva(projeto);
	}
	


}
