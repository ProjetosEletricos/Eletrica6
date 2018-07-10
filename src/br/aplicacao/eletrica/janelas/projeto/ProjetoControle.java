package br.aplicacao.eletrica.janelas.projeto;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Projeto;
import br.aplicacao.eletrica.servico.ProjetoService;
import br.aplicacao.eletrica.uteis.DataUtil;
import br.aplicacao.eletrica.uteis.Numero;
import br.aplicacao.eletrica.uteis.tableModel.GenericTableModel;

public class ProjetoControle {

	private PrincipalFrm frm;
	private Projeto projeto = new Projeto();
	private GenericTableModel<Projeto> tabela;
	private int tabelaSelecao = -1;

	public ProjetoControle(PrincipalFrm frm) {
		this.frm = frm;
		iniciaTabelaProjetos();
		adicionaActionListener();
		adicionaListSelectionListener();
		adicionaMouseListener();
		adicionaChangeListener();
		dataAtual();
	}

	private void adicionaActionListener() {
		new ProjetoAcaoBotoes(frm);
	}

	private void adicionaChangeListener() {
		// new ProjetoAcaoAba(frm);
	}

	private void adicionaListSelectionListener() {
		new ProjetoAcaoSelecao(frm);
	}

	private void adicionaMouseListener() {
		// new ProjetoAcaoClicarItem(frm);
	}

	public void apagaDadosFrm() {

		frm.getTxtAutor().setText("");
		frm.getTxtNomeProjeto().setText("");
		frm.getTxtDescricaoProjeto().setText("");
		frm.getTxtData().setText(DataUtil.Atual());
		frm.getLblIdProjeto().setText(null);
	}

	private void dataAtual() {
		frm.getTxtData().setText(DataUtil.Atual());
	}

	public Projeto getDadosFrm() {

		projeto.setId(Numero.stringToInteger(frm.getLblIdProjeto().getText()));
		projeto.setNome(frm.getTxtNomeProjeto().getText());
		projeto.setAutor(frm.getTxtAutor().getText());
		projeto.setDescricao(frm.getTxtDescricaoProjeto().getText());
		projeto.setData(frm.getTxtData().getText());

		return projeto;
	}

	public void iniciaTabelaProjetos() {

		tabela = new GenericTableModel<Projeto>(ProjetoService.getAll(), Projeto.class);
		frm.getTableProjetos().repaint();
		frm.getTableProjetos().setModel(tabela);
		if (tabelaSelecao >= 0) {
			frm.getTableProjetos().setRowSelectionInterval(tabelaSelecao, tabelaSelecao);
		}
	}

	public void preencheFrm(Projeto projeto) {
		if (projeto != null) {
			this.projeto = projeto;
			frm.getTxtAutor().setText(projeto.getAutor());
			frm.getTxtNomeProjeto().setText(projeto.getNome());
			frm.getTxtDescricaoProjeto().setText(projeto.getDescricao());
			frm.getTxtData().setText(projeto.getData());
			frm.getLblIdProjeto().setText(Integer.toString(projeto.getId()));
		}
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public GenericTableModel<Projeto> getTabela() {
		return tabela;
	}

	public void setTabela(GenericTableModel<Projeto> tabela) {
		this.tabela = tabela;
	}

	public int getTabelaSelecao() {
		return tabelaSelecao;
	}

	public void setTabelaSelecao(int tabelaSelecao) {
		this.tabelaSelecao = tabelaSelecao;
	}

}
