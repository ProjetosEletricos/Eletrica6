package br.aplicacao.eletrica.janelas.equipamento;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.uteis.ApenasNumero;

public class EquipamentoAcaoDigitar implements KeyListener {

	private PrincipalFrm frm;

	public EquipamentoAcaoDigitar(PrincipalFrm frm) {
		
		this.frm = frm;
		this.adicionarKeyListener();
	}

	private void adicionarKeyListener() {

		frm.getTxtFdEquipamento().addKeyListener(this);
		frm.getTxtFpEquipamento().addKeyListener(this);
		frm.getTxtFServicoEquipamento().addKeyListener(this);
		frm.getTxtFSimutaneadadeEquipamento().addKeyListener(this);
		frm.getTxtFUtilizacaoEquipamento().addKeyListener(this);
		frm.getTxtPerdasEquipamento().addKeyListener(this);
		frm.getTxtPotenciaEquipamento().addKeyListener(this);
		frm.getTxtQuantidadeEquipamento().addKeyListener(this);
		frm.getTxtRendimentoEquipamento().addKeyListener(this);
	
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent event) {

		ApenasNumero.campo(event, "txtFdEquipamento");
		ApenasNumero.campo(event, "txtFpEquipamento");
		ApenasNumero.campo(event, "txtFServicoEquipamento");
		ApenasNumero.campo(event, "txtFSimutaneadadeEquipamento");
		ApenasNumero.campo(event, "txtFUtilizacaoEquipamento");
		ApenasNumero.campo(event, "txtPerdasEquipamento");
		ApenasNumero.campo(event, "txtPotenciaEquipamento");
		ApenasNumero.campo(event, "txtQuantidadeEquipamento");
		ApenasNumero.campo(event, "txtRendimentoEquipamento");
	}

}
