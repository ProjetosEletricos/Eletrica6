package br.aplicacao.eletrica.janelas.fonte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Fonte;
import br.aplicacao.eletrica.modelo.projeto.Projeto;
import br.aplicacao.eletrica.servico.FonteService;
import br.aplicacao.eletrica.servico.ProjetoService;
import br.aplicacao.eletrica.uteis.Numero;

public class FonteAcaoBotoes implements ActionListener {

	private PrincipalFrm frm;

	public FonteAcaoBotoes(PrincipalFrm frm) {

		this.frm = frm;
		this.adicionaActionListener();
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == frm.getBtnExcluirFonte()) {

				FonteService.remove(frm.getFonteControle().getFonte());
				
				frm.getFonteControle().setTabelaSelecao(-1);
				frm.getFonteControle().iniciaTabelaFontes(Numero.stringToInteger(frm.getLblIdProjeto().getText()));
				frm.getFonteControle().apagaDadosFrm();

		} else if (event.getSource() == frm.getBtnSalvarFonte()) {

			this.salvar();

		} else if (event.getSource() == frm.getBtnCopiarFonte()) {

			frm.getLblIdFonte().setText(null);
			this.salvar();
		}
	}

	private void adicionaActionListener() {

		frm.getBtnCopiarFonte().addActionListener(this);
		frm.getBtnExcluirFonte().addActionListener(this);
		frm.getBtnSalvarFonte().addActionListener(this);

	}

	private void salvar() {

		if (Numero.stringToInteger(frm.getLblIdProjeto().getText()) > 0) {
			Projeto projeto = ProjetoService.getById(Numero.stringToInteger(frm.getLblIdProjeto().getText()));
			Fonte fonte = frm.getFonteControle().getDadosFrm();

			if (Numero.stringToInteger(frm.getLblIdFonte().getText()) == null) {
				projeto.getFontes().add(fonte);
				FonteService.salva(fonte);
			} else {
				FonteService.salva(fonte);
			}
			frm.getFonteControle().iniciaTabelaFontes(Numero.stringToInteger(frm.getLblIdProjeto().getText()));
		}
	}
}
