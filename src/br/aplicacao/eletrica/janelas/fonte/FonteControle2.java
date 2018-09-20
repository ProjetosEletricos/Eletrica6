package br.aplicacao.eletrica.janelas.fonte;

import java.util.List;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.Concessionaria;
import br.aplicacao.eletrica.modelo.Fonte;
import br.aplicacao.eletrica.uteis.Numero;
import br.aplicacao.eletrica.uteis.TrataID;
import br.aplicacao.eletrica.uteis.tableModel.GenericTableModel;

public class FonteControle2 {

	private PrincipalFrm frm;
	private Fonte fonte = new Fonte();
	private GenericTableModel<Fonte> tabela;
	private int tabelaSelecao = -1;

	public FonteControle2(PrincipalFrm frm) {
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
		// new FonteAcaoClicarItem(frm);
	}

	public void apagaDadosFrm() {

		frm.getTxtTensaoFonte().setText("");
		frm.getCbConcessionaria().setSelectedIndex(-1);
		frm.getTxtNomeFonte().setText("");
		frm.getLblIdFonte().setText("0");
	}

	public Fonte getDadosFrm() {

		Fonte fonte = new Fonte();

		fonte.setId(TrataID.StringToInteger(frm.getLblIdFonte().getText()));
		fonte.setConcessionaria((Concessionaria) frm.getCbConcessionaria().getModel().getSelectedItem());
		fonte.setNome(frm.getTxtNomeFonte().getText());
		fonte.setTensaoFN(Numero.stringToDouble(frm.getTxtTensaoFonte().getText(),0));
		fonte.setProjeto(frm.getProjetoControle().getProjeto());

		this.fonte = fonte;
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

	public void iniciaTabelaFontes(List<Fonte> lista) {

		try {
			tabela = new GenericTableModel<Fonte>(lista, Fonte.class);
			frm.getTableFontes().setModel(tabela);
			frm.getTableFontes().setRowSelectionInterval(tabelaSelecao, tabelaSelecao);

		} catch (Exception e) {

		}
	}

	public void preencheFrm(Fonte fonte) {

		if (fonte != null) {
			this.fonte = fonte;

			frm.getLblIdFonte().setText(Integer.toString(fonte.getId()));
			frm.getTxtTensaoFonte().setText(Numero.decimal(fonte.getTensaoFN(), "##,00"));
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
