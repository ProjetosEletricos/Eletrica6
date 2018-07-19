package br.aplicacao.eletrica.janelas.equipamento;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.uteis.Numero;

public class EquipamentoAcaoAba implements ChangeListener {

	private PrincipalFrm frm;

	public EquipamentoAcaoAba(PrincipalFrm frm) {

		this.frm = frm;
		this.adicionaChangeListener();
	}

	public void adicionaChangeListener() {

		frm.getAbas().addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {

		if (frm.getAbas().getSelectedComponent() == frm.getPanelEquipamento()) {

			if (!(Numero.stringToInteger(frm.getLblIdCircuito().getText()) == null)) {
				frm.getEquipamentoControle().apagaDadosFrm();
				frm.getEquipamentoControle()
						.iniciaTabelaEquipamento(Numero.stringToInteger(frm.getLblIdCircuito().getText()));
			} else {
				frm.getEquipamentoControle().apagaDadosFrm();
				frm.getEquipamentoControle().setTabelaSelecao(-1);
				frm.getEquipamentoControle().iniciaTabelaEquipamento(0);
			}
		}
	}
}
