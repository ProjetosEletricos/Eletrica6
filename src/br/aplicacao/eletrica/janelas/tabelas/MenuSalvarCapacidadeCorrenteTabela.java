package br.aplicacao.eletrica.janelas.tabelas;

import java.util.ArrayList;
import java.util.List;

import br.aplicacao.eletrica.modelo.CapacidadeCorrente;
import br.aplicacao.eletrica.servico.CapacidadeCorrenteService;
import br.aplicacao.eletrica.uteis.GravarCSV;
import br.aplicacao.eletrica.uteis.Lista;

public class MenuSalvarCapacidadeCorrenteTabela {

	private GravarCSV arquivo;

	public MenuSalvarCapacidadeCorrenteTabela(GravarCSV arquivo) {
		this.arquivo = arquivo;
	}

	public void abre() {

		// lista de objetos
		List<CapacidadeCorrente> lista = CapacidadeCorrenteService.getAll();
		// Primeira linha
		List<String> array1 = new ArrayList<String>();
		array1.add("NIVEL");
		array1.add("MATERIAL");
		array1.add("BITOLA");
		for (int i = 0; i < lista.size(); i++) {
			array1.add(lista.get(i).getMetodo());
		}
		//////////// lista de metodos
		array1 = Lista.tiraRepetidos(array1);
		arquivo.writeLine(array1);// salva primeira linha
		// Segunda linha
		List<String> array2 = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			array2.add(lista.get(i).getSecao().toString());
		}
		//////////// lista de secoes
		array2 = Lista.tiraRepetidos(array2);
		array2 = Lista.converteToString(Lista.ordenaCrescDouble(Lista.converteToDouble(array2)));
		// Terceira linha
		List<String> array3 = new ArrayList<String>();
		List<String> nivel = new ArrayList<String>();
		nivel.add("Baixa tensao");
		nivel.add("Media tensao");
		List<String> material = new ArrayList<String>();
		material.add("Cobre");
		material.add("Aluminio");
		boolean flag1 = false;
		boolean flag2 = false;
		for (int n = 0; n < nivel.size(); n++) {
			for (int m = 0; m < material.size(); m++) {
				for (int s = 0; s < array2.size(); s++) {
					array3.add(nivel.get(n));
					array3.add(material.get(m));
					array3.add(array2.get(s));
					for (int met = 3; met < array1.size(); met++) {
						for (int li2 = 0; li2 < lista.size(); li2++) {
							if (lista.get(li2).getSecao().toString().equals(array2.get(s).toString())
									&& lista.get(li2).getMetodo().equals(array1.get(met))
									&& lista.get(li2).getMaterial().equals(material.get(m))
									&& lista.get(li2).getNivel().toString().equals(nivel.get(n).toString())) {
								array3.add(lista.get(li2).getCorrente().toString());
								flag1 = true;
								flag2 = true;
								break;
							}
						}
						if (flag1 == true) {
							flag1 = false;
						} else {
							array3.add("0");
						}
					}
					if (flag2 == true) {
						arquivo.writeLine(array3);
						flag2 = false;
					}
					array3.clear();
				}
			}
		}
		arquivo.salva();
	}
}
