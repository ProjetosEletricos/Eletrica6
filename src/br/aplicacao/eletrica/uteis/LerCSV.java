package br.aplicacao.eletrica.uteis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class LerCSV {

	private String nomeArq;
	private String[][] matriz;

	public LerCSV(String arquivo) {
		this.nomeArq = arquivo;
		toMatriz();
	}

	public String[][] toMatriz() {

		String linha = "";
		String csvDivisor = ";";
		String[] lista;
		this.matriz = new String[0][0];
		BufferedReader br = null;

		try {

			InputStream in = getClass().getResourceAsStream(this.nomeArq);

			if (in == null) {

				FileInputStream is = new FileInputStream(this.nomeArq);
				InputStreamReader isr = new InputStreamReader(is, "ISO-8859-1");
				br = new BufferedReader(isr);

			} else {

				Reader reader = new InputStreamReader(in, "ISO-8859-1");
				br = new BufferedReader(reader);
			}

			while ((linha = br.readLine()) != null) {

				lista = linha.split(csvDivisor);
				matriz = Lista.listToMatriz(matriz, lista);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return matriz;
	}

	public void imprimir() {
		System.out.println("Tabela de nome: " + nomeArq);

		for (int i = 0; i < matriz.length; i++) {

			for (int f = 0; f < matriz[i].length; f++) {
				System.out.print(matriz[i][f] + " ");

			}
			System.out.println("");
		}

	}

}
