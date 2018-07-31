package br.aplicacao.eletrica.janelas.projeto;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.servico.ProjetoService;

public class ProjetoAcaoAba implements ChangeListener {

	private PrincipalFrm frm;

	public ProjetoAcaoAba(PrincipalFrm frm) {

		this.frm = frm;
		this.adicionaChangeListener();
	}

	public void adicionaChangeListener() {

		frm.getAbas().getModel().addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {

			if (frm.getAbas().getModel().getSelectedIndex() == 0) {

			frm.getProjetoControle().iniciaTabelaProjetos(ProjetoService.getAll());
		}
	}

}
