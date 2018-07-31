package br.aplicacao.eletrica.janelas.quadro;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;

public class QuadroAcaoAba implements ChangeListener {

	private PrincipalFrm frmPrincipal;

	public QuadroAcaoAba(PrincipalFrm frmPrincipal) {

		this.frmPrincipal = frmPrincipal;
		this.adicionaChangeListener();
	}

	public void adicionaChangeListener() {

		frmPrincipal.getAbas().getModel().addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {

		if (frmPrincipal.getAbas().getModel().getSelectedIndex() == 2) {
System.out.println("index: "+frmPrincipal.getAbas().getModel().getSelectedIndex());
			frmPrincipal.getQuadroControle()
					.iniciaTabelaQuadros(frmPrincipal.getFonteControle().getFonte().getQuadros());

		}
	}
}
