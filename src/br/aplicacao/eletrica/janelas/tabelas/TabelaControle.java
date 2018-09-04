package br.aplicacao.eletrica.janelas.tabelas;

import java.util.List;

import javax.swing.UIManager;

import br.aplicacao.eletrica.janelas.main.Base;
import br.aplicacao.eletrica.modelo.CapacidadeCorrente;
import br.aplicacao.eletrica.uteis.tableModel.GenericTableModel;

public class TabelaControle {

	private TabelaFrm frm;
	private GenericTableModel<CapacidadeCorrente> tabela;
	private int tabelaSelecao = -1;

	public TabelaControle(TabelaFrm frm) {
		this.frm = frm;
		adicionaActionListener();
		adicionaListSelectionListener();
		adicionaMouseListener();
		adicionaChangeListener();
		adicionaKeyListener();
		adicionaTableModelListener();
	}

	private void adicionaActionListener() {
		// new TabelaAcaoMenu(frm);
	}

	private void adicionaTableModelListener() {
		// new TabelaAcaoEditar(frm);
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
		// new TabelaAcaoClicarItem(frm);
	}
	
	public void apagaDadosFrm() {
/*
		frm.getTxtFdQuadro().setText("");
		frmPrincipal.getTxtFpQuadro().setText("");
		frmPrincipal.getTxtLocalQuadro().setText("");
		frmPrincipal.getTxtNomeQuadro().setText("");
		frmPrincipal.getCbUsabilidadeQuadro().setSelectedIndex(-1);
		frmPrincipal.getCbDrQuadro().setSelectedIndex(-1);
		frmPrincipal.getLblIdQuadro().setText(null);
		frmPrincipal.getCbQuadroPai().setSelectedIndex(-1);*/
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
