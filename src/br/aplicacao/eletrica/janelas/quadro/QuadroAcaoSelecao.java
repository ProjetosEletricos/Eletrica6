package br.aplicacao.eletrica.janelas.quadro;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.Quadro;

public class QuadroAcaoSelecao implements ListSelectionListener {

	private PrincipalFrm frmPrincipal;

	public QuadroAcaoSelecao(PrincipalFrm frm) {

		this.frmPrincipal = frm;
		this.AdicionarListSelectionListener();
	}

	private void AdicionarListSelectionListener() {

		frmPrincipal.getTableQuadros().getSelectionModel().addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (e.getFirstIndex() >= 0 && e.getValueIsAdjusting() == true && frmPrincipal.getTableQuadros().getSelectedRow() >= 0) {
			
			int linha = frmPrincipal.getTableQuadros().getSelectedRow();
			Quadro quadro = frmPrincipal.getQuadroControle().getTabela().loadItem(linha);
			frmPrincipal.getQuadroControle().preencheFrm(quadro);
			frmPrincipal.getQuadroControle().setTabelaSelecao(linha);
		}
	}
}
