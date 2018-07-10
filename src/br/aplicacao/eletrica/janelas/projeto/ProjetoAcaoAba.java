package br.aplicacao.eletrica.janelas.projeto;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;

public class ProjetoAcaoAba implements ChangeListener {

	private PrincipalFrm frm;

	public ProjetoAcaoAba(PrincipalFrm frm) {

		this.frm = frm;
		this.adicionaChangeListener();
	}

	public void adicionaChangeListener() {

		frm.getAbas().addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		frm.getProjetoControle().apagaDadosFrm();
		frm.getProjetoControle().iniciaTabelaProjetos();
	}

}
