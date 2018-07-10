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

	public static Double stringToDouble(String valor) {
		double dfDouble = 0;
		String pv = valor.replaceAll(",", ".");
		try {
			dfDouble = Double.parseDouble(pv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dfDouble;
	}

	public static Integer stringToInteger(String valor) {
		Integer inteiro = null;
		
		if(!(valor == null || valor.equals(""))) {
			String pv = valor.replaceAll(",", ".");
			inteiro = Integer.parseInt(pv);
		}
		return inteiro;
	}

}
