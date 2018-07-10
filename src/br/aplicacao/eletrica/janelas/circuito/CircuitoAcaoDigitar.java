package br.aplicacao.eletrica.janelas.circuito;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.uteis.ApenasNumero;

public class CircuitoAcaoDigitar implements KeyListener {

/*	private PrincipalFrm frm;
	private CircuitoControle controle;*/

	public CircuitoAcaoDigitar(PrincipalFrm frm) {
		/*
		 * this.controle = controle; this.frm = controle.getFrm();
		 */
		adicionarKeyListener();
	}

	public void adicionarKeyListener() {
/*
		frm.getTxtComprimentoCircuito().addKeyListener(this);
		frm.getTxtQTensaoCircuito().addKeyListener(this);
		frm.getTxtResistividadeTermCircuito().addKeyListener(this);
		frm.getTxtTemperaturaCircuito().addKeyListener(this);*/

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent event) {

		ApenasNumero.campo(event, "txtComprimentoCircuito");
		ApenasNumero.campo(event, "txtQTensaoCircuito");
		ApenasNumero.campo(event, "txtResistividadeTermCircuito");
		ApenasNumero.campo(event, "txtTemperaturaCircuito");

	}

}
