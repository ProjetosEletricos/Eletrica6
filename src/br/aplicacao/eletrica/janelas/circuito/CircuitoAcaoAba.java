package br.aplicacao.eletrica.janelas.circuito;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;

public class CircuitoAcaoAba implements ChangeListener {

	private PrincipalFrm frm;
	private CircuitoControle circuitoControle;

	public CircuitoAcaoAba(PrincipalFrm frm) {
		
		this.frm = frm;
		
		this.adicionaChangeListener();
	}

	public void adicionaChangeListener() {

		frm.getAbas().addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {

		if (frm.getAbas().getSelectedComponent() == frm.getPanelCircuito()) {
			this.circuitoControle = frm.getCircuitoControle();
			
			if (circuitoControle.getIdQuadro() > 0) {
				circuitoControle.apagaDadosFrm();
				circuitoControle.iniciaTabelaCircuitos(circuitoControle.getIdQuadro());
			} else {
				circuitoControle.apagaDadosFrm();
				circuitoControle.setTabelaSelecao(-1);
				circuitoControle.iniciaTabelaCircuitos(0);
			}
			// CircuitoControle.iniciaCbs();
		}
	}
}
