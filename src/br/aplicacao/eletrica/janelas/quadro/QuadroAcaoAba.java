package br.aplicacao.eletrica.janelas.quadro;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.uteis.Numero;

public class QuadroAcaoAba implements ChangeListener {

	private PrincipalFrm frm;

	public QuadroAcaoAba(PrincipalFrm frm) {

		
		this.frm = frm;
		this.adicionaChangeListener();
	}

	public void adicionaChangeListener() {

		frm.getAbas().addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		
		if (frm.getAbas().getSelectedComponent() == frm.getPanelQuadro()) {

			if (!(Numero.stringToInteger(frm.getLblIdFonte().getText()) == null)) {
				frm.getQuadroControle().apagaDadosFrm();
				frm.getQuadroControle().iniciaTabelaQuadros(Numero.stringToInteger(frm.getLblIdFonte().getText()));
			} else {
				frm.getQuadroControle().apagaDadosFrm();
				frm.getQuadroControle().setTabelaSelecao(-1);
				frm.getQuadroControle().iniciaTabelaQuadros(0);
			}

		}
	}
}
