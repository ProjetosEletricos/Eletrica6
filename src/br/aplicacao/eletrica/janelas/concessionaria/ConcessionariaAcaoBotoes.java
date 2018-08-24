package br.aplicacao.eletrica.janelas.concessionaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.aplicacao.eletrica.modelo.Concessionaria;
import br.aplicacao.eletrica.servico.ConcessionariaService;

public class ConcessionariaAcaoBotoes implements ActionListener {

	private ConcessionariaFrm frm;

	public ConcessionariaAcaoBotoes(ConcessionariaFrm frm) {

		this.frm = frm;
		this.adicionaActionListener();
	}

	private void adicionaActionListener() {

		frm.getBtnCopiarConcessionaria().addActionListener(this);
		frm.getBtnExcluirConcessionaria().addActionListener(this);
		frm.getBtnSalvarConcessionaria().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == frm.getBtnExcluirConcessionaria()) {

			Concessionaria concessionaria = frm.getControle().getConcessionaria();
			ConcessionariaService.remove(concessionaria);
			concessionaria.apagar();

			frm.getTableConcessionarias().clearSelection();
			frm.getControle().iniciaTabelaConcessionarias();
			frm.getControle().apagaDadosFrm();

		} else if (event.getSource() == frm.getBtnSalvarConcessionaria()) {

			this.salvar();

		} else if (event.getSource() == frm.getBtnCopiarConcessionaria()) {

			frm.getLblIdConcessionaria().setText("0");
			this.salvar();
		}
	}

	private void salvar() {

		Concessionaria concessionaria = frm.getControle().getDadosFrm();
		ConcessionariaService.salva(concessionaria);
		frm.getControle().iniciaTabelaConcessionarias();
		frm.getControle().apagaDadosFrm();
	}

}
