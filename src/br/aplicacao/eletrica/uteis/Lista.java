package br.aplicacao.eletrica.uteis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lista {

	public static List<String> tiraRepetidos(List<String> l) {

		for (int i = 0; i < l.size(); i++) {
			Object a = l.get(i);
			for (int j = i + 1; j < l.size(); j++) {
				Object b = l.get(j);
				if (a.equals(b)) {
					l.remove(j);
					j--;
				}
			}
		}
		return l;
	}

	public static List<String> ordenarString(List<String> lista) {
		ArrayList<String> A = new ArrayList<String>();
		ArrayList<String> B = new ArrayList<String>();
		ArrayList<String> C = new ArrayList<String>();
		ArrayList<String> novo = new ArrayList<String>();

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).toString().length() == 1) {
				A.add(lista.get(i));
			}
		}
		Arrays.sort(A.toArray());
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).toString().length() == 2) {
				B.add(lista.get(i));
			}
		}
		Arrays.sort(B.toArray());
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).toString().length() == 3) {
				C.add(lista.get(i));
			}
		}
		Arrays.sort(C.toArray());

		novo.addAll(A);
		novo.addAll(B);
		novo.addAll(C);

		return novo;
	}

	public static int maiorNumero(ArrayList<Integer> nFasesLista) {

		int aux = 0;

		for (int i = 0; i < nFasesLista.size(); i++) {
			if (nFasesLista.get(i) > aux) {
				aux = nFasesLista.get(i);
			}
		}
		return aux;
	}

	public static int maiorNumeroPosicao(ArrayList<Double> lista) {

		double aux = 0;
		int pos = 0;

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) > aux) {
				aux = lista.get(i);
				pos = i;
			}
		}
		return pos;
	}

	public static List<Double> converteToDouble(List<String> listaStrings) {
		List<Double> lista = new ArrayList<Double>();
		for (String x : listaStrings) {
			lista.add(Double.valueOf(x));
		}
		return lista;
	}
	
	public static List<String> converteToString(List<Double> listaDoubles) {
		List<String> lista = new ArrayList<String>();
		for (Double x : listaDoubles) {
			lista.add(x.toString());
		}
		return lista;
	}

	public static List<Double> ordenaCrescDouble(List<Double> listaDoubles) {
		List<Double> lista = new ArrayList<Double>();
		lista = listaDoubles;
		Collections.sort(lista);
		return lista; 
	}
	
	public static List<String> ordenaCrescString(List<String> listaStrings) {
		List<String> lista = new ArrayList<String>();
		lista = listaStrings;
		Collections.sort(lista);
		return lista; 
	}

	public static String[][] arrayToMatriz(String[][] matriz, ArrayList<String> lista) {

		String[][] geral = new String[matriz.length + 1][lista.size()];

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				try {
					geral[i][j] = matriz[i][j];
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}

		for (int i = 0; i < lista.size(); i++) {
			geral[geral.length - 1][i] = lista.get(i);
		}
		return geral;
	}

	public static String[][] listToMatriz(String[][] matriz, String[] lista) {

		String[][] geral = new String[matriz.length + 1][lista.length];

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				try {
					if (!(matriz[i][j] == null)) {
						geral[i][j] = matriz[i][j];
					} else {
						geral[i][j] = "0";
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}

		for (int i = 0; i < lista.length; i++) {
			geral[geral.length - 1][i] = lista[i];
		}
		return geral;
	}

	public static List<Object> addObjeto(List<Object> lista, int posicao, Object objeto){
		List<Object> nova = lista;
		nova.add("");
		for(int i = 0;i>lista.size()+1;i++) {
			if(posicao == i) {
				nova.set(posicao, lista.get(i));
			}else {
				nova.set(posicao, lista.get(i));
			}
		}
		
		return nova;
	}
}
