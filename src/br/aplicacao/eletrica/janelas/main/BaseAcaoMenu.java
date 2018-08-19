package br.aplicacao.eletrica.janelas.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import br.aplicacao.eletrica.janelas.tabelas.CapacidadeCorrente;
import br.aplicacao.eletrica.janelas.tabelas.TabelaControle;
import br.aplicacao.eletrica.janelas.tabelas.TabelaModeloFrm;
import br.aplicacao.eletrica.servico.CapacidadeCorrenteService;

public class BaseAcaoMenu implements ActionListener {
	private Base frm;

	public BaseAcaoMenu(Base frm) {
		this.frm = frm;
		this.adicionaActionListener();
	}

	private void adicionaActionListener() {

		frm.getMntmCapacidade1().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == frm.getMntmCapacidade1()) {

			List<CapacidadeCorrente> lista = CapacidadeCorrenteService.getAll();
			TabelaControle controle = new TabelaControle(new TabelaModeloFrm());
			controle.abreJanela();
			controle.iniciaTabela(lista);
		}
	}

}
