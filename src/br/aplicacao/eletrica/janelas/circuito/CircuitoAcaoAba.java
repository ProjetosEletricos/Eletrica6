package br.aplicacao.eletrica.janelas.circuito;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.aplicacao.eletrica.janelas.condutor.CondutorFrm;
import br.aplicacao.eletrica.janelas.curto.CurtoFrm;
import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.uteis.Numero;

public class CircuitoAcaoAba implements ChangeListener {

	private PrincipalFrm frmPrincipal;
	private CondutorFrm frmCondutor;
	private CurtoFrm frmCurto;

	public CircuitoAcaoAba(PrincipalFrm frmPrincipal, CondutorFrm frmCondutor, CurtoFrm frmCurto) {
		
		this.frmPrincipal = frmPrincipal;
		this.frmCondutor = frmCondutor;
		this.frmCurto = frmCurto;
		this.adicionaChangeListener();
	}

	public void adicionaChangeListener() {

		frmPrincipal.getAbas().addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {

		if (frmPrincipal.getAbas().getSelectedComponent() == frmPrincipal.getPanelCircuito()) {
			
			if (!(Numero.stringToInteger(frmPrincipal.getLblIdQuadro().getText()) == null)) {
				frmPrincipal.getCircuitoControle().apagaDadosFrm();
				frmCondutor.getCondutorControle().apagaDadosFrm();
				frmCurto.getCurtoControle().apagaDadosFrm();
				frmPrincipal.getCircuitoControle().iniciaTabelaCircuitos(Numero.stringToInteger(frmPrincipal.getLblIdQuadro().getText()));
			} else {
				frmPrincipal.getCircuitoControle().apagaDadosFrm();
				frmCondutor.getCondutorControle().apagaDadosFrm();
				frmCurto.getCurtoControle().apagaDadosFrm();
				frmPrincipal.getCircuitoControle().setTabelaSelecao(-1);
				frmPrincipal.getCircuitoControle().iniciaTabelaCircuitos(0);
			}
		}
	}
}
