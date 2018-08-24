package br.aplicacao.eletrica.janelas.circuito;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.Circuito;

public class CircuitoAcaoSelecao implements ListSelectionListener {

	private PrincipalFrm frm;

	public CircuitoAcaoSelecao(PrincipalFrm frm) {

		this.frm = frm;
		this.AdicionarListSelectionListener();
	}

	private void AdicionarListSelectionListener() {

		frm.getTableCircuitos().getSelectionModel().addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (e.getFirstIndex() >= 0 && e.getValueIsAdjusting() == true && frm.getTableCircuitos().getSelectedRow() >= 0) {

			int linha = frm.getTableCircuitos().getSelectedRow();
			Circuito circuito = frm.getCircuitoControle().getTabela().loadItem(linha);
			frm.getCircuitoControle().preencheFrm(circuito);
			frm.getCircuitoControle().setTabelaSelecao(linha);
		}

	}
}
