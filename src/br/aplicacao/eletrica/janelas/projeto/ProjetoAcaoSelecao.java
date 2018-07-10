package br.aplicacao.eletrica.janelas.projeto;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Projeto;

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
		
		int firstIndex = e.getFirstIndex();
		int row = frm.getTableProjetos().getSelectedRow();

		if (firstIndex >= 0 && row >= 0) {

			Projeto projeto = frm.getProjetoControle().getTabela().loadItem(row);
			frm.getProjetoControle().preencheFrm(projeto);
			frm.getProjetoControle().setTabelaSelecao(row);
		}
	}

}
