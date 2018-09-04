package br.aplicacao.eletrica.janelas.tabelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabelaAcaoMenu implements ActionListener {

	private TabelaFrm frm;

	public TabelaAcaoMenu(TabelaFrm frm) {

		this.frm = frm;
		this.adicionaActionListener();
	}

	private void adicionaActionListener() {

		frm.getMntmCarregarCSV().addActionListener(this);
		frm.getMntmSalvarCsv().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		/*
		 * JanelaSelecao janela = new JanelaSelecao(); janela.abre();
		 * 
		 * if (janela.confirma()) {
		 * 
		 * LerCSV dados = new LerCSV(janela.getSelecao().toString()); String[][] tabela
		 * = dados.lerTabela(); Util.salvarMatrizToTabelaCapacidadeCorrente(tabela);
		 * System.out.println("Passou por aqui novamente");
		 * System.out.println("Passou por aqui"); }
		 */

		if (event.getSource() == frm.getMntmSalvarCsv()) {


		}
	}
}
