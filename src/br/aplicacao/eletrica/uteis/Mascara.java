package br.aplicacao.eletrica.uteis;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class Mascara {

	public static MaskFormatter campo(String formato) {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter(formato);
		} catch (ParseException e) {
			System.out.println("Formato inv�lido em formNumero(): " + e);
			System.exit(0);
		}
		return mask;
	}
}
