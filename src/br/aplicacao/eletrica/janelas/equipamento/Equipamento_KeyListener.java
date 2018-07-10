package br.aplicacao.eletrica.janelas.equipamento;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.uteis.ApenasNumero;

public class Equipamento_KeyListener implements KeyListener {

	@SuppressWarnings("unused")
	private PrincipalFrm frm;

	public Equipamento_KeyListener() {
	
		adicionarKeyListener();

	}

	public void adicionarKeyListener() {

		/*
		 * frm.getTxtFtSimutaneiedade().addKeyListener(this);
		 * frm.getTxtRendimento().addKeyListener(this);
		 * frm.getTxtPotencia().addKeyListener(this);
		 * frm.getTxtFtDemanda().addKeyListener(this);
		 * frm.getTxtFtUtilizacao().addKeyListener(this);
		 * frm.getTxtFtServico().addKeyListener(this);
		 * frm.getTxtFtPotencia().addKeyListener(this);
		 * frm.getTxtPredasreator().addKeyListener(this);
		 */

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		ApenasNumero.campo(event, "txtPotencia");
		ApenasNumero.campo(event, "txtFtDemanda");
		ApenasNumero.campo(event, "txtFtSimutaneiedade");
		ApenasNumero.campo(event, "txtRendimento");
		ApenasNumero.campo(event, "txtFtUtilizacao");
		ApenasNumero.campo(event, "txtFtServico");
		ApenasNumero.campo(event, "txtFtPotencia");
		ApenasNumero.campo(event, "txtPerdasReator");
	}

}
