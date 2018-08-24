package br.aplicacao.eletrica.janelas.concessionaria;

import java.util.List;

import br.aplicacao.eletrica.modelo.Concessionaria;
import br.aplicacao.eletrica.servico.ConcessionariaService;
import br.aplicacao.eletrica.uteis.tableModel.GenericTableModel;

public class ConcessionariaControle {

	private ConcessionariaFrm frm;
	private Concessionaria concessionaria = new Concessionaria();
	private GenericTableModel<Concessionaria> tabela;
	private int tabelaSelecao = -1;

	public ConcessionariaControle(ConcessionariaFrm frm) {
		this.frm = frm;
		adicionaActionListener();
		adicionaListSelectionListener();
		iniciaTabelaConcessionarias();
	}

	private void adicionaActionListener() {
		new ConcessionariaAcaoBotoes(frm);
	}

	private void adicionaListSelectionListener() {
		new ConcessionariaAcaoSelecao(frm);
	}

	public void apagaDadosFrm() {

		frm.getTxtNomeConcessionaria().setText("");
		frm.getTxtLocalConcessionaria().setText("");
		frm.getLblIdConcessionaria().setText(null);
	}

	public Concessionaria getDadosFrm() {

		Concessionaria concessionaria = new Concessionaria();

		concessionaria.setId(Integer.parseInt(frm.getLblIdConcessionaria().getText()));
		concessionaria.setNome(frm.getTxtNomeConcessionaria().getText());
		concessionaria.setLocal(frm.getTxtLocalConcessionaria().getText());

		return concessionaria;
	}

	public void iniciaTabelaConcessionarias() {

		try {
			List<Concessionaria> lista = ConcessionariaService.getAll();
			frm.getTableConcessionarias().clearSelection();
			tabela = new GenericTableModel<Concessionaria>(lista, Concessionaria.class);

			frm.getTableConcessionarias().setModel(tabela);
		} catch (Exception e) {
			frm.getTableConcessionarias().removeAll();
		}
	}

	public void preencheFrm(Concessionaria concessionaria) {
		
		if (concessionaria != null) {
			this.setConcessionaria(concessionaria);
			
			frm.getLblIdConcessionaria().setText(Integer.toString(concessionaria.getId()));
			frm.getTxtNomeConcessionaria().setText(concessionaria.getNome());
			frm.getTxtLocalConcessionaria().setText(concessionaria.getLocal());
		}
	}


	public GenericTableModel<Concessionaria> getTabela() {
		return tabela;
	}

	public void setTabela(GenericTableModel<Concessionaria> tabela) {
		this.tabela = tabela;
	}

	public int getTabelaSelecao() {
		return tabelaSelecao;
	}

	public void setTabelaSelecao(int tabelaSelecao) {
		this.tabelaSelecao = tabelaSelecao;
	}

	public Concessionaria getConcessionaria() {
		return concessionaria;
	}

	public void setConcessionaria(Concessionaria concessionaria) {
		this.concessionaria = concessionaria;
	}

}
