package br.aplicacao.eletrica.janelas.fonte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.Fonte;
import br.aplicacao.eletrica.modelo.Projeto;
import br.aplicacao.eletrica.servico.FonteService;
import br.aplicacao.eletrica.servico.ProjetoService;
import br.aplicacao.eletrica.uteis.Numero;

public class FonteAcaoBotoes implements ActionListener {

	private PrincipalFrm frm;

	public FonteAcaoBotoes(PrincipalFrm frm) {

		this.frm = frm;
		this.adicionaActionListener();
	}

	private void adicionaActionListener() {

		frm.getBtnCopiarFonte().addActionListener(this);
		frm.getBtnExcluirFonte().addActionListener(this);
		frm.getBtnSalvarFonte().addActionListener(this);
		frm.getCbConcessionaria().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == frm.getBtnExcluirFonte()) {

			Projeto projeto = frm.getProjetoControle().getProjeto();
			Fonte fonte = frm.getFonteControle().getFonte();
			projeto.getFontes().remove(fonte);
			FonteService.remove(fonte);
			fonte.apagar();

			frm.getTableFontes().clearSelection();
			frm.getFonteControle().iniciaTabelaFontes(projeto.getFontes());
			frm.getFonteControle().apagaDadosFrm();

		} else if (event.getSource() == frm.getBtnSalvarFonte()) {

			this.salvar();

		} else if (event.getSource() == frm.getBtnCopiarFonte()) {

			frm.getLblIdFonte().setText("0");
			this.salvar();

		}
	}

	private void salvar() {

		if (Integer.valueOf(frm.getLblIdProjeto().getText()) > 0) {
			
			Projeto projeto = ProjetoService.getById(Numero.stringToInteger(frm.getLblIdProjeto().getText(),0));
			Fonte fonte = frm.getFonteControle().getDadosFrm();

			if (fonte.getId() == null) {
				projeto.addFonte(fonte);
				ProjetoService.salva(projeto);
			} else {
				FonteService.salva(fonte);
			}
			frm.getFonteControle().apagaDadosFrm();
			frm.getFonteControle().setTabelaSelecao(-1);
			frm.getFonteControle().iniciaTabelaFontes(projeto.getFontes());
		}
	}
}
