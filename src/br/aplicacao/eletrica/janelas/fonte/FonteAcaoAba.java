package br.aplicacao.eletrica.janelas.fonte;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;

public class FonteAcaoAba implements ChangeListener {

	private PrincipalFrm frm;

	public FonteAcaoAba(PrincipalFrm frm) {

		this.frm = frm;
		this.adicionaChangeListener();
	}

	public void adicionaChangeListener() {

		frm.getAbas().getModel().addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {

		if (frm.getAbas().getModel().getSelectedIndex() == 1) {

			frm.getFonteControle().iniciaTabelaFontes(frm.getProjetoControle().getProjeto().getFontes());
		}
	}
}
