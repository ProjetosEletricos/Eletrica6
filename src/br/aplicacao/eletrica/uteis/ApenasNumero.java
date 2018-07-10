package br.aplicacao.eletrica.uteis;

import java.awt.event.KeyEvent;

public class ApenasNumero {

	public static void campo(KeyEvent event, String nomeComponente) {

		String stri = String.valueOf(event.getKeyChar());
		char caract = event.getKeyChar();

		if (event.getComponent().getName().equals(nomeComponente) && !(stri.equals(","))
				&& !(caract >= KeyEvent.VK_0 && caract <= KeyEvent.VK_9)) {
			event.consume();

		}
	}

	private ApenasNumero() {
		throw new IllegalStateException("Utility class");
	}

}
