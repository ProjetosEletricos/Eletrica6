package br.aplicacao.eletrica.janelas.quadro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Fonte;
import br.aplicacao.eletrica.modelo.projeto.Quadro;
import br.aplicacao.eletrica.servico.FonteService;
import br.aplicacao.eletrica.servico.QuadroService;

public class QuadroAcaoBotoes implements ActionListener {

	private PrincipalFrm frm;
	private QuadroControle controle;

	public QuadroAcaoBotoes(PrincipalFrm frm) {

		
		this.frm = frm;
		this.adicionaActionListener();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		this.controle = frm.getQuadroControle();
		
		if (event.getSource() == frm.getBtnExcluirQuadro()) {

			int row = controle.getTabelaSelecao();

			if (row >= 0) {

				FonteService.getById(controle.getIdFonte()).getQuadros().remove(controle.getTabela().loadItem(row));

				controle.setTabelaSelecao(-1);
				controle.iniciaTabelaQuadros(controle.getIdFonte());
				controle.apagaDadosFrm();
			}

		} else if (event.getSource() == frm.getBtnSalvarQuadro()) {

			this.salvar();

		} else if (event.getSource() == frm.getBtnCopiarQuadro()) {

			frm.getLblIdQuadro().setText("0");
			this.salvar();
		}
	}

	private void adicionaActionListener() {

		frm.getBtnCopiarQuadro().addActionListener(this);
		frm.getBtnExcluirQuadro().addActionListener(this);
		frm.getBtnSalvarQuadro().addActionListener(this);
	}

	private void salvar() {

		if (controle.getIdFonte() > 0) {
			Fonte fonte = FonteService.getById(controle.getIdFonte());
			Quadro quadro = controle.getDadosFrm();
			if (!(quadro.equals(null))) {
				if (controle.getIdQuadro() == 0) {
					fonte.adicionaQuadro(quadro);
					FonteService.salva(fonte);
				} else {
					QuadroService.atualiza(quadro);
				}
			}
			controle.iniciaTabelaQuadros(controle.getIdFonte());
			controle.apagaDadosFrm();
		}
	}

}
