package br.aplicacao.eletrica.servico;

import java.util.List;

import br.aplicacao.eletrica.dao.JpaDAO;
import br.aplicacao.eletrica.modelo.projeto.Concessionaria;

public class ConcessionariaService {

	private final static JpaDAO<Concessionaria> DAO_CONCESSIONARIA = new JpaDAO<Concessionaria>(Concessionaria.class);

	public static List<Concessionaria> getAll() {
		List<Concessionaria> lista = DAO_CONCESSIONARIA.getAll();
		return lista;
	}

	public static List<Concessionaria> getByExpres(String expres, Object[] parameter) {

		return DAO_CONCESSIONARIA.getByExpres(expres, parameter);
	}

	public static Concessionaria getById(Integer id) {

		return DAO_CONCESSIONARIA.getById(id);
	}

	public static void remove(Concessionaria concessionaria) {

		DAO_CONCESSIONARIA.remove(concessionaria);
	}

	public static void removeById(Integer id) {

		DAO_CONCESSIONARIA.removeById(id);
	}

	public static void salva(Concessionaria concessionaria) {

		DAO_CONCESSIONARIA.salva(concessionaria);
	}

}
