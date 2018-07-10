package br.aplicacao.eletrica.janelas.quadro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Fonte;
import br.aplicacao.eletrica.modelo.projeto.Quadro;
import br.aplicacao.eletrica.servico.FonteService;
import br.aplicacao.eletrica.servico.QuadroService;
import br.aplicacao.eletrica.uteis.Numero;
import br.aplicacao.eletrica.uteis.tableModel.GenericTableModel;

public class QuadroControle {

	private PrincipalFrm frm;
	private Quadro quadro;
	private GenericTableModel<Quadro> tabela;
	private int tabelaSelecao = -1;

	public QuadroControle(PrincipalFrm frm) {
		this.frm = frm;
		adicionaActionListener();
		adicionaListSelectionListener();
		adicionaChangeListener();
		adicionaKeyListener();
		iniciaCbs();
	}

	private void adicionaActionListener() {
		new QuadroAcaoBotoes(frm);
	}

	private void adicionaChangeListener() {
		new QuadroAcaoAba(frm);
	}

	private void adicionaKeyListener() {
		new QuadroAcaoDigitar(frm);
	}

	private void adicionaListSelectionListener() {
		new QuadroAcaoSelecao(frm);
	}



	public void apagaDadosFrm() {

		frm.getTxtFdQuadro().setText("");
		frm.getTxtFpQuadro().setText("");
		frm.getTxtLocalQuadro().setText("");
		frm.getTxtNomeQuadro().setText("");
		frm.getCbUsabilidadeQuadro().setSelectedIndex(-1);
		frm.getCbDrQuadro().setSelectedIndex(-1);
		frm.getLblIdQuadro().setText("0");
	}

	public Quadro getDadosFrm() {

		Quadro quadro = new Quadro();

		if (!(frm.getLblIdQuadro().getText().equals("0"))) {
			quadro = QuadroService.getById(Integer.valueOf(frm.getLblIdQuadro().getText()));
			quadro.setId(Integer.parseInt(frm.getLblIdQuadro().getText()));
		}
		quadro.setFd(Numero.stringToDouble(frm.getTxtFdQuadro().getText()));
		quadro.setFp(Numero.stringToDouble(frm.getTxtFpQuadro().getText()));
		quadro.setLocal(frm.getTxtLocalQuadro().getText());
		quadro.setNome(frm.getTxtNomeQuadro().getText());
		quadro.setUsabilidade(frm.getCbUsabilidadeQuadro().getModel().getSelectedItem().toString());
		quadro.setDrGeral(frm.getCbDrQuadro().getModel().getSelectedItem().toString());
		quadro.setFonte(frm.getFonteControle().getFonte());

		return quadro;
	}

	private void iniciaCbUsabilidade() {
		frm.getCbUsabilidadeQuadro().setModel(new DefaultComboBoxModel<>());
		frm.getCbUsabilidadeQuadro().addItem("Iluminação");
		frm.getCbUsabilidadeQuadro().addItem("Motor");
		frm.getCbUsabilidadeQuadro().setSelectedIndex(0);
	}
	
	private void iniciaCbDrQuadro() {
		frm.getCbDrQuadro().setModel(new DefaultComboBoxModel<>());
		frm.getCbDrQuadro().addItem("Sim");
		frm.getCbDrQuadro().addItem("Não");
		frm.getCbDrQuadro().setSelectedIndex(0);
	}
	
	public void iniciaCbs() {
		iniciaCbDrQuadro();
		iniciaCbUsabilidade();
	}

	public void iniciaTabelaQuadros(Integer idFonte) {

		List<Quadro> lista = new ArrayList<Quadro>();

		if (!(idFonte == 0)) {

			Fonte fonte = FonteService.getById(idFonte);

			for (Quadro q : fonte.getQuadros()) {
				lista.add(q);
			}
		}

		tabela = new GenericTableModel<Quadro>(lista, Quadro.class);
		frm.getTableQuadros().repaint();
		frm.getTableQuadros().setModel(tabela);
		if (tabelaSelecao >= 0) {
			frm.getTableQuadros().setRowSelectionInterval(tabelaSelecao, tabelaSelecao);
		}
	}

	public void preencheFrm(Quadro quadro) {
		
		if (quadro != null) {
			this.quadro = quadro;
			
			frm.getTxtFdQuadro().setText(Numero.decimal(quadro.getFd(), "##,00"));
			frm.getTxtFpQuadro().setText(Numero.decimal(quadro.getFp(), "##,00"));
			frm.getTxtLocalQuadro().setText(quadro.getLocal());
			frm.getTxtNomeQuadro().setText(quadro.getNome());
			frm.getCbUsabilidadeQuadro().getModel().setSelectedItem(quadro.getUsabilidade());
			frm.getCbDrQuadro().getModel().setSelectedItem(quadro.getDrGeral());
			frm.getLblIdQuadro().setText(Integer.toString(quadro.getId()));
		}
	}


	public Quadro getQuadro() {
		return quadro;
	}

	public void setQuadro(Quadro quadro) {
		this.quadro = quadro;
	}
	
	public Integer getIdFonte() {
		return Integer.valueOf(frm.getLblIdFonte().getText());
	}
	
	public Integer getIdQuadro() {
		return Integer.valueOf(frm.getLblIdQuadro().getText());
	}

	public GenericTableModel<Quadro> getTabela() {
		return tabela;
	}

	public void setTabela(GenericTableModel<Quadro> tabela) {
		this.tabela = tabela;
	}

	public int getTabelaSelecao() {
		return tabelaSelecao;
	}

	public void setTabelaSelecao(int tabelaSelecao) {
		this.tabelaSelecao = tabelaSelecao;
	}
}
