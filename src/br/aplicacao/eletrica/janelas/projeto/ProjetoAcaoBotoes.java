package br.aplicacao.eletrica.janelas.projeto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.servico.ProjetoService;

public class ProjetoAcaoBotoes implements ActionListener {

	private PrincipalFrm frm;

	public ProjetoAcaoBotoes(PrincipalFrm frm) {

		this.frm = frm;
		this.adicionaActionListener();

	}

	private void adicionaActionListener() {

		frm.getBtnCopiarProjeto().addActionListener(this);
		frm.getBtnExcluirProjeto().addActionListener(this);
		frm.getBtnSalvarProjeto().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == frm.getBtnExcluirProjeto()) {

			ProjetoService.remove(frm.getProjetoControle().getProjeto());
			frm.getProjetoControle().getProjeto().apagar();

			frm.getTableProjetos().clearSelection();
			frm.getProjetoControle().iniciaTabelaProjetos(ProjetoService.getAll());
			frm.getProjetoControle().apagaDadosFrm();

		} else if (event.getSource() == frm.getBtnSalvarProjeto()) {

			this.salvar();

		} else if (event.getSource() == frm.getBtnCopiarProjeto()) {

			frm.getLblIdProjeto().setText(null);
			this.salvar();

		}
	}

	private void salvar() {

		
		ProjetoService.salva(frm.getProjetoControle().getDadosFrm());
		frm.getProjetoControle().apagaDadosFrm();
		frm.getProjetoControle().setTabelaSelecao(-1);
		frm.getProjetoControle().iniciaTabelaProjetos(ProjetoService.getAll());

	}

}
