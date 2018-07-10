package br.aplicacao.eletrica.janelas.fonte;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.uteis.Numero;

public class FonteAcaoAba implements ChangeListener {

	private PrincipalFrm frm;

	public FonteAcaoAba(PrincipalFrm frm) {

		this.frm = frm;
		
		this.adicionaChangeListener();
	}

	public void adicionaChangeListener() {

		frm.getAbas().addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		
		if (frm.getAbas().getSelectedComponent() == frm.getPanelFonte()) {
			frm.getFonteControle().iniciaCbConcessionaria();
			if (!(Numero.stringToInteger(frm.getLblIdProjeto().getText()) == null)) {
				frm.getFonteControle().apagaDadosFrm();
				frm.getFonteControle().iniciaTabelaFontes(Numero.stringToInteger(frm.getLblIdProjeto().getText()));
			} else {
				frm.getFonteControle().apagaDadosFrm();
				frm.getFonteControle().setTabelaSelecao(-1);
				frm.getFonteControle().iniciaTabelaFontes(0);
			}
			
		}

	}

}
