package br.aplicacao.eletrica.janelas.quadro;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import br.aplicacao.eletrica.janelas.condutor.CondutorFrm;
import br.aplicacao.eletrica.janelas.curto.CurtoFrm;
import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Quadro;
import br.aplicacao.eletrica.uteis.Numero;
import br.aplicacao.eletrica.uteis.tableModel.GenericTableModel;

public class QuadroControle {

	private PrincipalFrm frmPrincipal;
	private Quadro quadro = new Quadro();
	private CondutorFrm frmCondutor = new CondutorFrm();
	private CurtoFrm frmCurto = new CurtoFrm();
	private GenericTableModel<Quadro> tabela;
	private int tabelaSelecao = -1;

	public QuadroControle(PrincipalFrm frm) {
		this.frmPrincipal = frm;
		adicionaActionListener();
		adicionaListSelectionListener();
		adicionaChangeListener();
		adicionaKeyListener();
		iniciaCbs();
	}

	private void adicionaActionListener() {
		new QuadroAcaoBotoes(frmPrincipal, frmCondutor, frmCurto);
	}

	private void adicionaChangeListener() {
		new QuadroAcaoAba(frmPrincipal);
	}

	private void adicionaKeyListener() {
		new QuadroAcaoDigitar(frmPrincipal);
	}

	private void adicionaListSelectionListener() {
		new QuadroAcaoSelecao(frmPrincipal);
	}

	public void apagaDadosFrm() {

		frmPrincipal.getTxtFdQuadro().setText("");
		frmPrincipal.getTxtFpQuadro().setText("");
		frmPrincipal.getTxtLocalQuadro().setText("");
		frmPrincipal.getTxtNomeQuadro().setText("");
		frmPrincipal.getCbUsabilidadeQuadro().setSelectedIndex(-1);
		frmPrincipal.getCbDrQuadro().setSelectedIndex(-1);
		frmPrincipal.getLblIdQuadro().setText(null);
		frmPrincipal.getCbQuadroPai().setSelectedIndex(-1);
	}

	public Quadro getDadosFrm() {

		Quadro quadro = new Quadro();
		quadro = this.quadro;

		quadro.setId(Numero.stringToInteger(frmPrincipal.getLblIdQuadro().getText()));
		quadro.setFd(Numero.stringToDouble(frmPrincipal.getTxtFdQuadro().getText()));
		quadro.setFp(Numero.stringToDouble(frmPrincipal.getTxtFpQuadro().getText()));
		quadro.setLocal(frmPrincipal.getTxtLocalQuadro().getText());
		quadro.setNome(frmPrincipal.getTxtNomeQuadro().getText());
		quadro.setUsabilidade(frmPrincipal.getCbUsabilidadeQuadro().getModel().getSelectedItem().toString());
		quadro.setDrGeral(frmPrincipal.getCbDrQuadro().getModel().getSelectedItem().toString());
		quadro.setCondutor(frmCondutor.getCondutorControle().getCondutor());
		quadro.setCurto(frmCurto.getCurtoControle().getCurto());
		quadro.setFonte(frmPrincipal.getFonteControle().getFonte());
		quadro.setQuadroPaiQuadro((Quadro) frmPrincipal.getCbQuadroPai().getModel().getSelectedItem());
		// quadro.setQuadro(frmPrincipal.getQuadroControle().getQuadro());

		return quadro;
	}

	private void iniciaCbUsabilidade() {
		frmPrincipal.getCbUsabilidadeQuadro().setModel(new DefaultComboBoxModel<>());
		frmPrincipal.getCbUsabilidadeQuadro().addItem("Iluminação");
		frmPrincipal.getCbUsabilidadeQuadro().addItem("Motor");
		frmPrincipal.getCbUsabilidadeQuadro().setSelectedIndex(0);
	}

	private void iniciaCbDrQuadro() {
		frmPrincipal.getCbDrQuadro().setModel(new DefaultComboBoxModel<>());
		frmPrincipal.getCbDrQuadro().addItem("Sim");
		frmPrincipal.getCbDrQuadro().addItem("Não");
		frmPrincipal.getCbDrQuadro().setSelectedIndex(0);
	}

	public void iniciaCbs() {
		iniciaCbDrQuadro();
		iniciaCbUsabilidade();
	}

	public void iniciaTabelaQuadros(List<Quadro> lista) {

		/*
		 * List<Quadro> lista = new ArrayList<Quadro>();
		 * 
		 * if (!(idFonte == 0)) {
		 * 
		 * Fonte fonte = FonteService.getById(idFonte);
		 * 
		 * for (Quadro q : fonte.getQuadros()) { lista.add(q); } }
		 */
		try {
			tabela = new GenericTableModel<Quadro>(lista, Quadro.class);
			frmPrincipal.getTableQuadros().setModel(tabela);
			frmPrincipal.getTableQuadros().setRowSelectionInterval(tabelaSelecao, tabelaSelecao);

		} catch (Exception e) {

		}
	}

	public void preencheFrm(Quadro quadro) {

		if (quadro != null) {
			this.quadro = quadro;

			frmPrincipal.getTxtFdQuadro().setText(Numero.decimal(quadro.getFd(), "##,00"));
			frmPrincipal.getTxtFpQuadro().setText(Numero.decimal(quadro.getFp(), "##,00"));
			frmPrincipal.getTxtLocalQuadro().setText(quadro.getLocal());
			frmPrincipal.getTxtNomeQuadro().setText(quadro.getNome());
			frmPrincipal.getCbUsabilidadeQuadro().getModel().setSelectedItem(quadro.getUsabilidade());
			frmPrincipal.getCbDrQuadro().getModel().setSelectedItem(quadro.getDrGeral());
			frmPrincipal.getLblIdQuadro().setText(Integer.toString(quadro.getId()));
			frmPrincipal.getCbQuadroPai().getModel().setSelectedItem(quadro.getQuadroPaiQuadro());
			frmCondutor.getCondutorControle().preencheFrm(quadro.getCondutor());
			frmCurto.getCurtoControle().preencheFrm(quadro.getCurto());
		}
	}

	public Quadro getQuadro() {
		return quadro;
	}

	public void setQuadro(Quadro quadro) {
		this.quadro = quadro;
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
