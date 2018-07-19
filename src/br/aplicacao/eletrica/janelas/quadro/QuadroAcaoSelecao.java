package br.aplicacao.eletrica.janelas.quadro;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Quadro;
import br.aplicacao.eletrica.uteis.Numero;

public class QuadroAcaoSelecao implements ListSelectionListener {

	private PrincipalFrm frm;

	public QuadroAcaoSelecao(PrincipalFrm frm) {

		
		this.frm = frm;
		this.AdicionarListSelectionListener();
	}

	private void AdicionarListSelectionListener() {

		frm.getTableQuadros().getSelectionModel().addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		int firstIndex = e.getFirstIndex();


		if (firstIndex >= 0 && !(Numero.stringToInteger(frm.getLblIdFonte().getText()) == null)) {

			Quadro quadro = frm.getQuadroControle().getTabela().loadItem(firstIndex);
			frm.getQuadroControle().preencheFrm(quadro);
			frm.getQuadroControle().setTabelaSelecao(firstIndex);
		}
	}

}
