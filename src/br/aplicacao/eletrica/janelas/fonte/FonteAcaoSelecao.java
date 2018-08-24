package br.aplicacao.eletrica.janelas.fonte;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.Fonte;

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

		if (e.getFirstIndex() >= 0 && e.getValueIsAdjusting() == true && frm.getTableFontes().getSelectedRow() >= 0) {

			int linha = frm.getTableFontes().getSelectedRow();
			Fonte fonte = frm.getFonteControle().getTabela().loadItem(linha);
			frm.getFonteControle().preencheFrm(fonte);
			frm.getFonteControle().setTabelaSelecao(linha);
		}
	}
}
