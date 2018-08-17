package br.aplicacao.eletrica.janelas.main;

import br.aplicacao.eletrica.janelas.tabelas.TabelaModeloFrm;

public class BaseControle {

	private TabelaModeloFrm frm;
	private Base frmBase;
	private int tabelaSelecao = -1;

	public BaseControle(Base frm) {
		this.frmBase = frm;
		adicionaActionListener();
		adicionaListSelectionListener();
		adicionaMouseListener();
		adicionaChangeListener();
		adicionaKeyListener();
	}

	private void adicionaActionListener() {
		new BaseAcaoMenu(frmBase, frm);
	}

	private void adicionaChangeListener() {
		// new FonteAcaoAba(frm);
	}

	private void adicionaKeyListener() {
		// new FonteAcaoDigitar(frm);
	}

	private void adicionaListSelectionListener() {
		// new FonteAcaoSelecao(frm);
	}

	private void adicionaMouseListener() {
		// new FonteAcaoClicarItem(frm);
	}

	public int getTabelaSelecao() {
		return tabelaSelecao;
	}

	public void setTabelaSelecao(int tabelaSelecao) {
		this.tabelaSelecao = tabelaSelecao;
	}
}
