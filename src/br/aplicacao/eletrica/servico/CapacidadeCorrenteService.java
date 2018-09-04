package br.aplicacao.eletrica.servico;

import java.util.List;

import br.aplicacao.eletrica.dao.JpaDAO;
import br.aplicacao.eletrica.modelo.CapacidadeCorrente;
import br.aplicacao.eletrica.uteis.Numero;

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

	public static void salva(String[][] matriz) {
		for (int i = 1; i < matriz.length; i++) {

			for (int j = 3; j < matriz[i].length; j++) {
				CapacidadeCorrente cc = new CapacidadeCorrente();
				cc.setNivel(matriz[i][0]);
				cc.setMaterial(matriz[i][1]);
				cc.setSecao(Numero.stringToDouble(matriz[i][2],0));
				cc.setMetodo(matriz[0][j]);
				cc.setnCondutorCarr(
						Integer.valueOf((Character.toString((matriz[0][j].charAt(matriz[0][j].length() - 1))))));
				cc.setCorrente(Numero.stringToDouble(matriz[i][j],0));

				CapacidadeCorrenteService.salva(cc);
			}

		}
	}

	public static void limpa() {

		DAO_CAPACIDADE.excluirTodos("CapacidadeCorrente");

	}

}
