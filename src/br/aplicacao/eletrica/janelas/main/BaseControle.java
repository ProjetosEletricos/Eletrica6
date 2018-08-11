package br.aplicacao.eletrica.janelas.main;

import java.util.List;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.janelas.tabelas.CapacidadeCorrente;
import br.aplicacao.eletrica.janelas.tabelas.TabelaModeloFrm;
import br.aplicacao.eletrica.modelo.projeto.Concessionaria;
import br.aplicacao.eletrica.modelo.projeto.Fonte;
import br.aplicacao.eletrica.uteis.Numero;
import br.aplicacao.eletrica.uteis.tableModel.GenericTableModel;

public class BaseControle {

	private TabelaModeloFrm frm;
	private Base frmBase;
	private GenericTableModel<CapacidadeCorrente> tabela;
	private int tabelaSelecao = -1;

	public BaseControle(TabelaModeloFrm frm) {
		this.frm = frm;
		adicionaActionListener();
		adicionaListSelectionListener();
		adicionaMouseListener();
		adicionaChangeListener();
		adicionaKeyListener();
	}

	private void adicionaActionListener() {
		new BaseAcaoMenu(frmBase);
	}

	private void adicionaChangeListener() {
		new FonteAcaoAba(frm);
	}

	private void adicionaKeyListener() {
		new FonteAcaoDigitar(frm);
	}

	private void adicionaListSelectionListener() {
		new FonteAcaoSelecao(frm);
	}

	private void adicionaMouseListener() {
		// new FonteAcaoClicarItem(frm);
	}


	public void iniciaTabela(List<CapacidadeCorrente> lista) {

		try {
			tabela = new GenericTableModel<CapacidadeCorrente>(lista, CapacidadeCorrente.class);
			frm.getTable().setModel(tabela);
		} catch (Exception e) {

		}
	}

	public GenericTableModel<CapacidadeCorrente> getTabela() {
		return tabela;
	}

	public void setTabela(GenericTableModel<CapacidadeCorrente> tabela) {
		this.tabela = tabela;
	}

	public int getTabelaSelecao() {
		return tabelaSelecao;
	}

	public void setTabelaSelecao(int tabelaSelecao) {
		this.tabelaSelecao = tabelaSelecao;
	}
}
