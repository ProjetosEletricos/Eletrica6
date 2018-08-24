package br.aplicacao.eletrica.servico;

import java.util.List;

import br.aplicacao.eletrica.dao.JpaDAO;
import br.aplicacao.eletrica.modelo.Equipamento;

public class EquipamentoService {

	private final static JpaDAO<Equipamento> DAO_EQUIPAMENTO = new JpaDAO<Equipamento>(Equipamento.class);

	public static List<Equipamento> getAll() {
		List<Equipamento> lista = DAO_EQUIPAMENTO.getAll();
		return lista;
	}

	public static List<Equipamento> getByExpres(String expres, Object[] parameter) {

		return DAO_EQUIPAMENTO.getByExpres(expres, parameter);
	}

	public static Equipamento getById(Integer id) {

		return DAO_EQUIPAMENTO.getById(id);
	}

	public static void remove(Equipamento equipamento) {

		DAO_EQUIPAMENTO.remove(equipamento);
	}

	public static void removeById(Integer id) {

		DAO_EQUIPAMENTO.removeById(id);
	}

	public static void salva(Equipamento equipamento) {

		DAO_EQUIPAMENTO.salva(equipamento);
	}

}
