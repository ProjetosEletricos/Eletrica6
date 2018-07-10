package br.aplicacao.eletrica.janelas.circuito;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Circuito;

public class CircuitoAcaoSelecao implements ListSelectionListener {

	private PrincipalFrm frm;
	private CircuitoControle controle;

	public CircuitoAcaoSelecao(PrincipalFrm frm) {
		
		this.frm = frm;
		this.AdicionarListSelectionListener();
	}

	private void AdicionarListSelectionListener() {

		frm.getTableCircuitos().getSelectionModel().addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		this.controle = frm.getCircuitoControle();
		
		int firstIndex = e.getFirstIndex();
		int row = frm.getTableCircuitos().getSelectedRow();

		if (firstIndex >= 0 && row >= 0) {

			Circuito circuito = controle.getTabela().loadItem(row);
			controle.preencheFrm(circuito);
			controle.setTabelaSelecao(row);
		}

	}
}
