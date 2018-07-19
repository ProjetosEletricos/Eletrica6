package br.aplicacao.eletrica.janelas.quadro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Fonte;
import br.aplicacao.eletrica.modelo.projeto.Quadro;
import br.aplicacao.eletrica.servico.FonteService;
import br.aplicacao.eletrica.servico.QuadroService;
import br.aplicacao.eletrica.uteis.Numero;

public class QuadroAcaoBotoes implements ActionListener {

	private PrincipalFrm frm;

	public QuadroAcaoBotoes(PrincipalFrm frm) {

		this.frm = frm;
		this.adicionaActionListener();
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == frm.getBtnExcluirQuadro()) {

			Fonte fonte = frm.getFonteControle().getFonte();
			Quadro quadro = frm.getQuadroControle().getQuadro();
			fonte.getQuadros().remove(quadro);
			QuadroService.remove(quadro);
			quadro.getCircuitos().clear();

			frm.getQuadroControle().setTabelaSelecao(-1);
			frm.getQuadroControle().iniciaTabelaQuadros(Numero.stringToInteger(frm.getLblIdFonte().getText()));
			frm.getQuadroControle().apagaDadosFrm();

		} else if (event.getSource() == frm.getBtnSalvarQuadro()) {

			this.salvar();

		} else if (event.getSource() == frm.getBtnCopiarQuadro()) {

			frm.getLblIdQuadro().repaint();
			this.salvar();
		}
	}

	private void adicionaActionListener() {

		frm.getBtnCopiarQuadro().addActionListener(this);
		frm.getBtnExcluirQuadro().addActionListener(this);
		frm.getBtnSalvarQuadro().addActionListener(this);
	}

	private void salvar() {

		if (Numero.stringToInteger(frm.getLblIdFonte().getText()) > 0) {
			
			Fonte fonte = FonteService.getById(Numero.stringToInteger(frm.getLblIdFonte().getText()));
			Quadro quadro = frm.getQuadroControle().getDadosFrm();

			if (Numero.stringToInteger(frm.getLblIdQuadro().getText()) == null) {
				fonte.getQuadros().add(quadro);
				FonteService.salva(fonte);
			} else {
				QuadroService.salva(quadro);
			}
			frm.getQuadroControle().iniciaTabelaQuadros(Numero.stringToInteger(frm.getLblIdFonte().getText()));
		}
	}

}
