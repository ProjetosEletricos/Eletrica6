package br.aplicacao.eletrica.janelas.fonte;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Concessionaria;
import br.aplicacao.eletrica.modelo.projeto.Fonte;
import br.aplicacao.eletrica.modelo.projeto.Projeto;
import br.aplicacao.eletrica.servico.ProjetoService;
import br.aplicacao.eletrica.uteis.Numero;
import br.aplicacao.eletrica.uteis.tableModel.GenericTableModel;

public class FonteControle {

	private PrincipalFrm frm;
	private Fonte fonte = new Fonte();
	private GenericTableModel<Fonte> tabela;
	private int tabelaSelecao = -1;

	public FonteControle(PrincipalFrm frm) {
		this.frm = frm;
		adicionaActionListener();
		adicionaListSelectionListener();
		adicionaMouseListener();
		adicionaChangeListener();
		adicionaKeyListener();
	}

	private void adicionaActionListener() {
		new FonteAcaoBotoes(frm);
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
		new FonteAcaoClicarItem(frm);
	}

	public void apagaDadosFrm() {

		frm.getTxtTensaoFonte().setText("");
		frm.getCbConcessionaria().setSelectedIndex(-1);
		frm.getTxtNomeFonte().setText("");
		frm.getLblIdFonte().setText(null);
	}

	public Fonte getDadosFrm() {

		fonte.setId(Numero.stringToInteger(frm.getLblIdFonte().getText()));
		fonte.setConcessionaria((Concessionaria) frm.getCbConcessionaria().getModel().getSelectedItem());
		fonte.setNome(frm.getTxtNomeFonte().getText());
		fonte.setTensaoFN(Numero.stringToDouble(frm.getTxtTensaoFonte().getText()));
		fonte.setProjeto(frm.getProjetoControle().getProjeto());

		return fonte;
	}

	public void iniciaCbConcessionaria() {
		/*
		 * List<Concessionaria> lista = new ArrayList<Concessionaria>(); lista =
		 * ConcessionariaService.getAll(); frm.getCbConcessionaria().removeAllItems();
		 * frm.setConcessionaria(lista);
		 */
	}

	public void iniciaCbs() {
		iniciaCbConcessionaria();
	}

	public void iniciaTabelaFontes(Integer idProjeto) {

		List<Fonte> lista = new ArrayList<Fonte>();

		if (!(idProjeto == 0)) {

			Projeto projeto = ProjetoService.getById(idProjeto);

			for (Fonte f : projeto.getFontes()) {
				lista.add(f);
			}
		}
		if (!(lista.isEmpty() || lista == null)) {
			tabela = new GenericTableModel<Fonte>(lista, Fonte.class);
			frm.getTableFontes().repaint();
			frm.getTableFontes().setModel(tabela);
			if (tabelaSelecao >= 0) {
				frm.getTableFontes().setRowSelectionInterval(tabelaSelecao, tabelaSelecao);
			}
		} else {
			frm.getTableFontes().repaint();
			frm.getTableFontes().setModel(new DefaultTableModel());
		}
	}

	public void preencheFrm(Fonte fonte) {
		
		if (fonte != null) {
			this.fonte = fonte;

			frm.getLblIdFonte().setText(Integer.toString(fonte.getId()));
			frm.getTxtTensaoFonte().setText(Numero.decimal(fonte.getTensaoFN(), "0"));
			frm.getCbConcessionaria().getModel().setSelectedItem(fonte.getConcessionaria());
			frm.getTxtNomeFonte().setText(fonte.getNome());
		}
	}

	public Fonte getFonte() {
		return fonte;
	}

	public void setFonte(Fonte fonte) {
		this.fonte = fonte;
	}

	public GenericTableModel<Fonte> getTabela() {
		return tabela;
	}

	public void setTabela(GenericTableModel<Fonte> tabela) {
		this.tabela = tabela;
	}

	public int getTabelaSelecao() {
		return tabelaSelecao;
	}

	public void setTabelaSelecao(int tabelaSelecao) {
		this.tabelaSelecao = tabelaSelecao;
	}
}
