package br.aplicacao.eletrica.janelas.fonte;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.uteis.ApenasNumero;

public class FonteAcaoDigitar implements KeyListener {

	private PrincipalFrm frm;

	public FonteAcaoDigitar(PrincipalFrm frm) {
		
		this.frm = frm;
		this.adicionarKeyListener();
	}

	private void adicionarKeyListener() {

		frm.getTxtTensaoFonte().addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent event) {

		ApenasNumero.campo(event, "txtTensaoFonte");

	}

}
