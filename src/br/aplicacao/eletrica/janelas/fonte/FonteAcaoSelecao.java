package br.aplicacao.eletrica.janelas.fonte;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Fonte;
import br.aplicacao.eletrica.uteis.Numero;

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
		

		if (firstIndex >= 0 && !(Numero.stringToInteger(frm.getLblIdProjeto().getText()) == null)) {
			Fonte fonte = frm.getFonteControle().getTabela().loadItem(firstIndex);
			frm.getFonteControle().preencheFrm(fonte);
			frm.getFonteControle().setTabelaSelecao(firstIndex);
		}
	}

}
