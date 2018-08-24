package br.aplicacao.eletrica.janelas.projeto;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.Projeto;

public class ProjetoAcaoSelecao implements ListSelectionListener {

	private PrincipalFrm frm;

	public ProjetoAcaoSelecao(PrincipalFrm frm) {

		this.frm = frm;
		this.AdicionarListSelectionListener();
	}

	private void AdicionarListSelectionListener() {

		frm.getTableProjetos().getSelectionModel().addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (e.getFirstIndex() >= 0 && e.getValueIsAdjusting() == true && frm.getTableProjetos().getSelectedRow() >= 0) {

			int linha = frm.getTableProjetos().getSelectedRow();
			Projeto projeto = frm.getProjetoControle().getTabela().loadItem(linha);
			frm.getProjetoControle().preencheFrm(projeto);
			frm.getProjetoControle().setTabelaSelecao(linha);
		}
	}
}
