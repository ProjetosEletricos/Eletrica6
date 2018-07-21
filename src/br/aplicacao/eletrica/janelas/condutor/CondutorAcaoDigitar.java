package br.aplicacao.eletrica.janelas.condutor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.aplicacao.eletrica.uteis.ApenasNumero;

public class CondutorAcaoDigitar implements KeyListener {

	private CondutorFrm frm;

	public CondutorAcaoDigitar(CondutorFrm frm) {

		this.frm = frm;
		this.adicionarKeyListener();
	}

	private void adicionarKeyListener() {

		frm.getTxtComprimentoCondutor().addKeyListener(this);
		frm.getTxtQuedaTensaoCondutor().addKeyListener(this);
		frm.getTxtResistTermicaCondutor().addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent event) {

		ApenasNumero.campo(event, "txtComprimentoCondutor");
		ApenasNumero.campo(event, "txtQuedaTensaoCondutor");
		ApenasNumero.campo(event, "txtResistTermicaCondutor");
	}

}
