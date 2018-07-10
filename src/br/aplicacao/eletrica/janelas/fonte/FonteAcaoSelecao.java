package br.aplicacao.eletrica.janelas.fonte;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Fonte;

public class FonteAcaoSelecao implements ListSelectionListener {

	private PrincipalFrm frm;

	public FonteAcaoSelecao(PrincipalFrm frm) {

		this.frm = frm;
		
		this.AdicionarListSelectionListener();
	}

	private void AdicionarListSelectionListener() {

		frm.getTableFontes().getSelectionModel().addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		int firstIndex = e.getFirstIndex();
		int row = frm.getTableFontes().getSelectedRow();

		if (firstIndex >= 0) {

			Fonte fonte = frm.getFonteControle().getFonte();
			frm.getFonteControle().preencheFrm(fonte);
			frm.getFonteControle().setTabelaSelecao(row);
		}
	}

}
