package br.aplicacao.eletrica.janelas.circuito;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.uteis.ApenasNumero;

public class CircuitoAcaoDigitar implements KeyListener {

	private PrincipalFrm frmPrincipal;

	public CircuitoAcaoDigitar(PrincipalFrm frmPrincipal) {

		this.frmPrincipal = frmPrincipal;

		this.adicionarKeyListener();
	}

	private void adicionarKeyListener() {

		frmPrincipal.getTxtFdEquipamento().addKeyListener(this);
		frmPrincipal.getTxtFpEquipamento().addKeyListener(this);
		frmPrincipal.getTxtPotenciaEquipamento().addKeyListener(this);
		frmPrincipal.getTxtFServicoEquipamento().addKeyListener(this);
		frmPrincipal.getTxtFSimutaneadadeEquipamento().addKeyListener(this);
		frmPrincipal.getTxtFUtilizacaoEquipamento().addKeyListener(this);
		frmPrincipal.getTxtRendimentoEquipamento().addKeyListener(this);

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent event) {

		ApenasNumero.campo(event, "txtPotenciaEquipamento");
		ApenasNumero.campo(event, "txtFpEquipamento");
		ApenasNumero.campo(event, "txtRendimentoEquipamento");
		ApenasNumero.campo(event, "txtFdEquipamento");
		ApenasNumero.campo(event, "txtFUtilizacaoEquipamento");
		ApenasNumero.campo(event, "txtFServicoEquipamento");
		ApenasNumero.campo(event, "txtFSimutaneadadeEquipamento");

	}

}
