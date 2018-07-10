package br.aplicacao.eletrica.janelas.circuito;

import java.util.ArrayList;
import java.util.List;

import br.aplicacao.eletrica.janelas.condutor.CondutorControle;
import br.aplicacao.eletrica.janelas.curto.CurtoControle;
import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Circuito;
import br.aplicacao.eletrica.modelo.projeto.Quadro;
import br.aplicacao.eletrica.servico.CircuitoService;
import br.aplicacao.eletrica.servico.QuadroService;
import br.aplicacao.eletrica.uteis.tableModel.GenericTableModel;

public class CircuitoControle {

	private PrincipalFrm frm;
	private Circuito circuito;
	private GenericTableModel<Circuito> tabela;
	private int tabelaSelecao = -1;

	public CircuitoControle(PrincipalFrm frm) {
		this.frm = frm;
		adicionaActionListener();
		adicionaListSelectionListener();
		adicionaChangeListener();
		adicionaKeyListener();

	}

	private void adicionaActionListener() {
		new CircuitoAcaoBotoes(frm);
	}

	private void adicionaChangeListener() {
		new CircuitoAcaoAba(frm);
	}

	private void adicionaKeyListener() {
		new CircuitoAcaoDigitar(frm);
	}

	private void adicionaListSelectionListener() {
		new CircuitoAcaoSelecao(frm);
	}

	public void apagaDadosFrm() {

		frm.getTxtNomeCircuito().setText("");
		frm.getLblIdCircuito().setText("0");
	}

	public Circuito getDadosFrm(CondutorControle condutorControle, CurtoControle curtoControle) {

		Circuito circuito = new Circuito();

		if (!(frm.getLblIdCircuito().getText().equals("0"))) {
			circuito = CircuitoService.getById(Integer.valueOf(frm.getLblIdCircuito().getText()));
			circuito.setId(Integer.parseInt(frm.getLblIdCircuito().getText()));
		}
		circuito.setNome(frm.getTxtNomeCircuito().getText());
		circuito.setCondutor(condutorControle.getCondutor());
		circuito.setCurto(curtoControle.getCurto());
		circuito.setQuadro(frm.getQuadroControle().getQuadro());

		return circuito;
	}

	public void iniciaTabelaCircuitos(Integer idQuadro) {

		List<Circuito> lista = new ArrayList<Circuito>();

		if (!(idQuadro == 0)) {

			Quadro quadro = QuadroService.getById(idQuadro);

			for (Circuito c : quadro.getCircuitos()) {
				lista.add(c);
			}
		}

		tabela = new GenericTableModel<Circuito>(lista, Circuito.class);
		frm.getTableCircuitos().repaint();
		frm.getTableCircuitos().setModel(tabela);
		if (tabelaSelecao >= 0) {
			frm.getTableCircuitos().setRowSelectionInterval(tabelaSelecao, tabelaSelecao);
		}
	}

	public void preencheFrm(Circuito circuito) {

		if (circuito != null) {
			this.circuito = circuito;
			frm.getTxtNomeCircuito().setText(circuito.getNome());
			frm.getLblIdCircuito().setText(Integer.toString(circuito.getId()));

		}
	}

	public PrincipalFrm getFrm() {
		return frm;
	}

	public void setFrm(PrincipalFrm frm) {
		this.frm = frm;
	}

	public Integer getIdCircuito() {
		return Integer.valueOf(frm.getLblIdCircuito().getText());
	}

	public Integer getIdQuadro() {
		return Integer.valueOf(frm.getLblIdQuadro().getText());
	}

	public Circuito getCircuito() {
		return circuito;
	}

	public void setCircuito(Circuito circuito) {
		this.circuito = circuito;
	}

	public GenericTableModel<Circuito> getTabela() {
		return tabela;
	}

	public void setTabela(GenericTableModel<Circuito> tabela) {
		this.tabela = tabela;
	}

	public int getTabelaSelecao() {
		return tabelaSelecao;
	}

	public void setTabelaSelecao(int tabelaSelecao) {
		this.tabelaSelecao = tabelaSelecao;
	}
}
