package br.aplicacao.eletrica.janelas.equipamento;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;

public class EquipamentoAcaoAba implements ChangeListener {

	private PrincipalFrm frm;

	public EquipamentoAcaoAba(PrincipalFrm frm) {

		this.frm = frm;
		this.adicionaChangeListener();
	}

	public void adicionaChangeListener() {

		frm.getAbas().getModel().addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {

		if (frm.getAbas().getModel().getSelectedIndex() == 4) {

			frm.getEquipamentoControle()
					.iniciaTabelaEquipamento(frm.getCircuitoControle().getCircuito().getEquipamentos());

		}
	}
}
