package br.aplicacao.eletrica.janelas.concessionaria;

import java.util.List;

import br.aplicacao.eletrica.modelo.projeto.Concessionaria;
import br.aplicacao.eletrica.servico.ConcessionariaService;
import br.aplicacao.eletrica.uteis.tableModel.GenericTableModel;

public class ConcessionariaControle {

	private ConcessionariaFrm frm;
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
		frm.getLblIdConcessionaria().setText("0");
	}
	
	public Integer getIdConcessionaria() {
		return Integer.valueOf(frm.getLblIdConcessionaria().getText());
	}

	public Concessionaria getDadosFrm() {

		Concessionaria concessionaria = new Concessionaria();

		if (!(frm.getLblIdConcessionaria().getText().equals("0"))) {
			concessionaria = ConcessionariaService.getById(Integer.valueOf(frm.getLblIdConcessionaria().getText()));
			concessionaria.setId(Integer.parseInt(frm.getLblIdConcessionaria().getText()));
		}
		concessionaria.setNome(frm.getTxtNomeConcessionaria().getText());
		concessionaria.setLocal(frm.getTxtLocalConcessionaria().getText());

		return concessionaria;
	}

	public void iniciaTabelaConcessionarias() {

		List<Concessionaria> lista = ConcessionariaService.getAll();
		tabela = new GenericTableModel<Concessionaria>(lista, Concessionaria.class);
		frm.getTableConcessionarias().repaint();
		frm.getTableConcessionarias().setModel(tabela);
		if (tabelaSelecao >= 0) {
			frm.getTableConcessionarias().setRowSelectionInterval(tabelaSelecao, tabelaSelecao);
		}
	}

	public void preencheFrm(Concessionaria concessionaria) {
		if (concessionaria != null) {
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

}
