package br.aplicacao.eletrica.janelas.tabelas;

import java.util.List;

import javax.swing.UIManager;

import br.aplicacao.eletrica.janelas.main.Base;
import br.aplicacao.eletrica.janelas.tabelas.TabelaModeloFrm;
import br.aplicacao.eletrica.uteis.tableModel.GenericTableModel;

public class TabelaControle {

	private TabelaModeloFrm frm;
	private GenericTableModel<CapacidadeCorrente> tabela;
	private int tabelaSelecao = -1;

	public TabelaControle(TabelaModeloFrm frm) {
		this.frm = frm;
		adicionaActionListener();
		adicionaListSelectionListener();
		adicionaMouseListener();
		adicionaChangeListener();
		adicionaKeyListener();
		adicionaTableModelListener();
	}

	private void adicionaActionListener() {
		//new BaseAcaoMenu(frmBase, frm);
	}
	
	private void adicionaTableModelListener() {
		new TabelaAcaoEditar(frm);
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
	
	public void iniciaTabela(List<CapacidadeCorrente> lista) {

		try {
			tabela = new GenericTableModel<CapacidadeCorrente>(lista, CapacidadeCorrente.class);

			frm.getTable().setModel(tabela);
			frm.getTable().setRowSelectionInterval(tabelaSelecao, tabelaSelecao);

		} catch (Exception e) {

		}
	}
	
	public void abreJanela() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			Base.desktopPane.add(frm);
			frm.setVisible(true);
			frm.setPosicao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public GenericTableModel<CapacidadeCorrente> getTabela() {
		return tabela;
	}

	public void setTabela(GenericTableModel<CapacidadeCorrente> tabela) {
		this.tabela = tabela;
	}

}
