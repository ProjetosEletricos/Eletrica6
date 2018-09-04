package br.aplicacao.eletrica.janelas.circuito;

import java.util.List;

import br.aplicacao.eletrica.janelas.condutor.CondutorFrm;
import br.aplicacao.eletrica.janelas.curto.CurtoFrm;
import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.Circuito;
import br.aplicacao.eletrica.uteis.TrataID;
import br.aplicacao.eletrica.uteis.tableModel.GenericTableModel;

public class CircuitoControle {

	private Circuito circuito = new Circuito();
	private PrincipalFrm frmPrincipal;
	private CondutorFrm frmCondutor = new CondutorFrm();
	private CurtoFrm frmCurto = new CurtoFrm();
	private GenericTableModel<Circuito> tabela;
	private int tabelaSelecao = -1;

	public CircuitoControle(PrincipalFrm frm) {
		this.frmPrincipal = frm;
		adicionaActionListener();
		adicionaListSelectionListener();
		adicionaChangeListener();
		adicionaKeyListener();

	}

	private void adicionaActionListener() {
		new CircuitoAcaoBotoes(frmPrincipal, frmCondutor, frmCurto);
	}

	private void adicionaChangeListener() {
		new CircuitoAcaoAba(frmPrincipal);
	}

	private void adicionaKeyListener() {
		new CircuitoAcaoDigitar(frmPrincipal);
	}

	private void adicionaListSelectionListener() {
		new CircuitoAcaoSelecao(frmPrincipal);
	}

	public void apagaDadosFrm() {

		frmPrincipal.getTxtNomeCircuito().setText("");
		frmPrincipal.getLblIdCircuito().setText(null);
	}

	public Circuito getDadosFrm() {

		Circuito circuito = new Circuito();
		circuito = this.circuito;

		circuito.setId(TrataID.StringToInteger(frmPrincipal.getLblIdCircuito().getText()));
		circuito.setNome(frmPrincipal.getTxtNomeCircuito().getText());
		circuito.setCondutor(frmCondutor.getCondutorControle().getCondutor());
		circuito.setCurto(frmCurto.getCurtoControle().getCurto());
		circuito.setQuadro(frmPrincipal.getQuadroControle().getQuadro());

		return circuito;
	}

	public void iniciaTabelaCircuitos(List<Circuito> lista) {

		/*
		 * List<Circuito> lista = new ArrayList<Circuito>();
		 * 
		 * if (!(idQuadro == 0)) {
		 * 
		 * Quadro quadro = QuadroService.getById(idQuadro);
		 * 
		 * for (Circuito c : quadro.getCircuitos()) { lista.add(c); } }
		 */
		try {
			tabela = new GenericTableModel<Circuito>(lista, Circuito.class);
			frmPrincipal.getTableCircuitos().setModel(tabela);
			frmPrincipal.getTableCircuitos().setRowSelectionInterval(tabelaSelecao, tabelaSelecao);
		} catch (Exception e) {

		}
	}

	public void preencheFrm(Circuito circuito) {

		if (circuito != null) {
			this.circuito = circuito;

			frmPrincipal.getTxtNomeCircuito().setText(circuito.getNome());
			frmPrincipal.getLblIdCircuito().setText(Integer.toString(circuito.getId()));
			frmCondutor.getCondutorControle().preencheFrm(circuito.getCondutor());
			frmCurto.getCurtoControle().preencheFrm(circuito.getCurto());
		}
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
