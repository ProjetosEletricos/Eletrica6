package br.aplicacao.eletrica.janelas.quadro;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.aplicacao.eletrica.janelas.condutor.CondutorFrm;
import br.aplicacao.eletrica.janelas.curto.CurtoFrm;
import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.uteis.Numero;

public class QuadroAcaoAba implements ChangeListener {

	private PrincipalFrm frmPrincipal;
	private CondutorFrm frmCondutor;
	private CurtoFrm frmCurto;

	public QuadroAcaoAba(PrincipalFrm frmPrincipal, CondutorFrm frmCondutor, CurtoFrm frmCurto) {

		
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
		
		if (frmPrincipal.getAbas().getSelectedComponent() == frmPrincipal.getPanelQuadro()) {

			if (!(Numero.stringToInteger(frmPrincipal.getLblIdFonte().getText()) == null)) {
				frmPrincipal.getQuadroControle().apagaDadosFrm();
				frmCondutor.getCondutorControle().apagaDadosFrm();
				frmCurto.getCurtoControle().apagaDadosFrm();
				frmPrincipal.getQuadroControle().iniciaTabelaQuadros(Numero.stringToInteger(frmPrincipal.getLblIdFonte().getText()));
			} else {
				frmPrincipal.getQuadroControle().apagaDadosFrm();
				frmCondutor.getCondutorControle().apagaDadosFrm();
				frmCurto.getCurtoControle().apagaDadosFrm();
				frmPrincipal.getQuadroControle().setTabelaSelecao(-1);
				frmPrincipal.getQuadroControle().iniciaTabelaQuadros(0);
			}

		}
	}
}
