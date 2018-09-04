package br.aplicacao.eletrica.uteis;

import java.text.DecimalFormat;

public class Numero {

	public static String decimal(Double valor, String formato) {

		DecimalFormat df = null;
		try {
			df = new DecimalFormat(formato);
		} catch (IllegalArgumentException e) {
			System.out.println("Formatação incorreta em decimal(): " + e);
		}
		String dfString = df.format(valor);
		return dfString;
	}

	public static Double stringToDouble(String valor, double valorPadrao) {
		double dfDouble = 0;
		String pv = valor.replaceAll(",", ".");
		if (valor.equals("")) {
			dfDouble = valorPadrao;
		} else {
			dfDouble = Double.parseDouble(pv);
		}
		return dfDouble;
	}

	public static Integer stringToInteger(String valor, int valorPadrao) {
		Integer inteiro = 0;
		String pv = valor.replaceAll(",", ".");
		if (valor.equals("")) {
			inteiro = valorPadrao;
		} else {
			inteiro = Integer.parseInt(pv);
		}
		return inteiro;
	}
}
