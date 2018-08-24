package br.aplicacao.eletrica.janelas.concessionaria;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.aplicacao.eletrica.modelo.Concessionaria;

public class ConcessionariaAcaoSelecao implements ListSelectionListener {

	private ConcessionariaFrm frm;
	private ConcessionariaControle controle;

	public ConcessionariaAcaoSelecao(ConcessionariaFrm frm) {

		this.frm = frm;
		
		this.AdicionarListSelectionListener();
	}

	private void AdicionarListSelectionListener() {

		frm.getTableConcessionarias().getSelectionModel().addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		this.controle = frm.getControle();
		
		int firstIndex = e.getFirstIndex();
		int row = frm.getTableConcessionarias().getSelectedRow();

		if (firstIndex >= 0 && row >= 0) {

			Concessionaria concessionaria = controle.getTabela().loadItem(row);
			controle.preencheFrm(concessionaria);
			controle.setTabelaSelecao(row);
		}
	}

}
