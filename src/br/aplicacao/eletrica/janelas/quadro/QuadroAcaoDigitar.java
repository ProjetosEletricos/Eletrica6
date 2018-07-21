package br.aplicacao.eletrica.janelas.quadro;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.uteis.ApenasNumero;

public class QuadroAcaoDigitar implements KeyListener {

	private PrincipalFrm frm;

	public QuadroAcaoDigitar(PrincipalFrm frm) {
		
		this.frm = frm;
		this.adicionarKeyListener();
	}

	protected void adicionarKeyListener() {

		frm.getTxtFdQuadro().addKeyListener(this);
		frm.getTxtFpQuadro().addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent event) {

		ApenasNumero.campo(event, "txtFdQuadro");
		ApenasNumero.campo(event, "txtFpQuadro");

	}

}
