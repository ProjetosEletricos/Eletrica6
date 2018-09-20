package br.aplicacao.eletrica.janelas.projeto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.Projeto;
import br.aplicacao.eletrica.servico.ProjetoService;
import br.aplicacao.eletrica.uteis.TrataID;

public class ProjetoAcaoBotoes2 implements ActionListener {

	private PrincipalFrm frm;

	public ProjetoAcaoBotoes2(PrincipalFrm frm) {

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

			ProjetoService.removeById(TrataID.StringToInteger(frm.getLblIdProjeto().getText()));
			frm.getProjetoControle().getProjeto().apagar();

			frm.getTableProjetos().clearSelection();
			frm.getProjetoControle().iniciaTabelaProjetos(ProjetoService.getAll());
			frm.getProjetoControle().apagaDadosFrm();

		} else if (event.getSource() == frm.getBtnSalvarProjeto()) {

			this.salvar(frm.getProjetoControle().getDadosFrm());
			
		} else if (event.getSource() == frm.getBtnCopiarProjeto()) {

			Projeto projeto = ProjetoService.getById(TrataID.StringToInteger(frm.getLblIdProjeto().getText()));
			projeto.setId(null);
			//projeto.getFontes().get(0).setProjeto(null);
			this.salvar(projeto);

		}
	}

	private void salvar(Projeto projeto) {

		ProjetoService.salva(projeto);
		frm.getProjetoControle().apagaDadosFrm();
		frm.getProjetoControle().setTabelaSelecao(-1);
		frm.getProjetoControle().iniciaTabelaProjetos(ProjetoService.getAll());

	}

}
