package br.aplicacao.eletrica.janelas.quadro;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;

public class QuadroAcaoAba implements ChangeListener {

	private PrincipalFrm frm;
	private QuadroControle controle;

	public QuadroAcaoAba(PrincipalFrm frm) {

		
		this.frm = frm;
		this.adicionaChangeListener();
	}

	public void adicionaChangeListener() {

		frm.getAbas().addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		this.controle = frm.getQuadroControle();
		
		if (frm.getAbas().getSelectedComponent() == frm.getPanelQuadro()) {

			if (controle.getIdFonte() > 0) {
				controle.apagaDadosFrm();
				controle.iniciaTabelaQuadros(controle.getIdFonte());
			} else {
				controle.apagaDadosFrm();
				controle.setTabelaSelecao(-1);
				controle.iniciaTabelaQuadros(0);
			}
			// QuadroControle.iniciaCbs();
		}
	}
}
