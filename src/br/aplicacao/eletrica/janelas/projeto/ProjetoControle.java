package br.aplicacao.eletrica.janelas.projeto;

import java.util.List;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.Projeto;
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
		iniciaTabelaProjetos(ProjetoService.getAll());
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
		new ProjetoAcaoAba(frm);
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

		Projeto projeto = new Projeto();
		projeto = this.projeto;

		projeto.setId(Numero.stringToInteger(frm.getLblIdProjeto().getText()));
		projeto.setNome(frm.getTxtNomeProjeto().getText());
		projeto.setAutor(frm.getTxtAutor().getText());
		projeto.setDescricao(frm.getTxtDescricaoProjeto().getText());
		projeto.setData(frm.getTxtData().getText());

		return projeto;
	}

	public void iniciaTabelaProjetos(List<Projeto> lista) {

		try {
			tabela = new GenericTableModel<Projeto>(lista, Projeto.class);
			frm.getTableProjetos().setModel(tabela);
			frm.getTableProjetos().setRowSelectionInterval(tabelaSelecao, tabelaSelecao);

		} catch (Exception e) {

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

	public int getTabelaSelecao() {
		return tabelaSelecao;
	}

	public void setTabelaSelecao(int tabelaSelecao) {
		this.tabelaSelecao = tabelaSelecao;
	}

	public void setTabela(GenericTableModel<Projeto> tabela) {
		this.tabela = tabela;
	}

}
