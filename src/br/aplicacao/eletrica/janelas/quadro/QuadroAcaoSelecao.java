package br.aplicacao.eletrica.janelas.quadro;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Quadro;

public class QuadroAcaoSelecao implements ListSelectionListener {

	private PrincipalFrm frm;
	private QuadroControle controle;

	public QuadroAcaoSelecao(PrincipalFrm frm) {

		
		this.frm = frm;
		this.AdicionarListSelectionListener();
	}

	private void AdicionarListSelectionListener() {

		frm.getTableQuadros().getSelectionModel().addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		this.controle = frm.getQuadroControle();
		
		int firstIndex = e.getFirstIndex();
		int row = frm.getTableQuadros().getSelectedRow();

		if (firstIndex >= 0 && row >= 0) {

			Quadro quadro = controle.getTabela().loadItem(row);
			controle.preencheFrm(quadro);
			controle.setTabelaSelecao(row);
		}
	}

}
