package br.aplicacao.eletrica.janelas.concessionaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.aplicacao.eletrica.modelo.projeto.Concessionaria;
import br.aplicacao.eletrica.servico.ConcessionariaService;

public class ConcessionariaAcaoBotoes implements ActionListener {

	private ConcessionariaFrm frm;
	private ConcessionariaControle controle;

	public ConcessionariaAcaoBotoes(ConcessionariaFrm frm) {

		this.frm = frm;
		
		this.adicionaActionListener();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		this.controle = frm.getControle();
		
		if (event.getSource() == frm.getBtnExcluirConcessionaria()) {
			int row = controle.getTabelaSelecao();

			if (row >= 0) {

				ConcessionariaService.removeById(controle.getIdConcessionaria());

				controle.setTabelaSelecao(-1);
				controle.iniciaTabelaConcessionarias();
				controle.apagaDadosFrm();
			}

		} else if (event.getSource() == frm.getBtnSalvarConcessionaria()) {

			this.salvar();

		} else if (event.getSource() == frm.getBtnCopiarConcessionaria()) {

			frm.getLblIdConcessionaria().setText("0");
			this.salvar();
		}
	}

	private void adicionaActionListener() {

		frm.getBtnCopiarConcessionaria().addActionListener(this);
		frm.getBtnExcluirConcessionaria().addActionListener(this);
		frm.getBtnSalvarConcessionaria().addActionListener(this);
	}

	private void salvar() {

		Concessionaria concessionaria = controle.getDadosFrm();
		ConcessionariaService.salva(concessionaria);
		controle.iniciaTabelaConcessionarias();
		controle.apagaDadosFrm();
	}

}
