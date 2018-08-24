package br.aplicacao.eletrica.janelas.tabelas;

import br.aplicacao.eletrica.servico.CapacidadeCorrenteService;
import br.aplicacao.eletrica.uteis.Numero;

public class Util {

	public static void salvarMatrizToTabelaCapacidadeCorrente(String[][] matriz) {
		for (int i = 1; i < matriz.length; i++) {

			for (int j = 1; j < matriz[i].length; j++) {
				CapacidadeCorrente cc = new CapacidadeCorrente();
				cc.setNivel(matriz[i][0]);
				cc.setMaterial(matriz[i][1]);
				cc.setSecao(Numero.stringToDouble(matriz[i][0]));
				cc.setMetodo(matriz[0][j]);
				cc.setnCondutorCarr(
						Integer.valueOf((Character.toString((matriz[0][j].charAt(matriz[0][j].length() - 1))))));
				cc.setCorrente(Numero.stringToDouble(matriz[i][j]));

				CapacidadeCorrenteService.salva(cc);
			}

		}
	}
}
