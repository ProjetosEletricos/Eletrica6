package br.aplicacao.eletrica.janelas.circuito;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;

public class CircuitoAcaoAba implements ChangeListener {

	private PrincipalFrm frmPrincipal;

	public CircuitoAcaoAba(PrincipalFrm frmPrincipal) {

		this.frmPrincipal = frmPrincipal;
		this.adicionaChangeListener();
	}

	public void adicionaChangeListener() {

		frmPrincipal.getAbas().getModel().addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {

		if (frmPrincipal.getAbas().getModel().getSelectedIndex() == 3) {
		
			frmPrincipal.getCircuitoControle()
					.iniciaTabelaCircuitos(frmPrincipal.getQuadroControle().getQuadro().getCircuitos());
		}
	}
}
