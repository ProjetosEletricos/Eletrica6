package br.aplicacao.eletrica.janelas.equipamento;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Circuito;
import br.aplicacao.eletrica.modelo.projeto.Equipamento;
import br.aplicacao.eletrica.servico.CircuitoService;
import br.aplicacao.eletrica.uteis.Numero;
import br.aplicacao.eletrica.uteis.tableModel.GenericTableModel;

public class EquipamentoControle {

	private PrincipalFrm frm;
	private Equipamento equipamento = new Equipamento();
	private GenericTableModel<Equipamento> tabela;
	private int tabelaSelecao = -1;

	public EquipamentoControle(PrincipalFrm frm) {
		this.frm = frm;
		adicionaActionListener();
		adicionaListSelectionListener();
		adicionaChangeListener();
		adicionaKeyListener();
		iniciaCbs();
	}

	private void adicionaActionListener() {
		new EquipamentoAcaoBotoes(frm);
	}

	private void adicionaChangeListener() {
		new EquipamentoAcaoAba(frm);
	}

	private void adicionaKeyListener() {
		new EquipamentoAcaoDigitar(frm);
	}

	private void adicionaListSelectionListener() {
		new EquipamentoAcaoSelecao(frm);
	}

	public void apagaDadosFrm() {

		frm.getTxtFdEquipamento().setText("");
		frm.getTxtFpEquipamento().setText("");
		frm.getTxtFServicoEquipamento().setText("");
		frm.getTxtFSimutaneadadeEquipamento().setText("");
		frm.getTxtFUtilizacaoEquipamento().setText("");
		frm.getTxtLocalEquipamento().setText("");
		frm.getTxtNomeEquipamento().setText("");
		frm.getTxtPerdasEquipamento().setText("");
		frm.getTxtPotenciaEquipamento().setText("");
		frm.getTxtRendimentoEquipamento().setText("");
		frm.getTxtQuantidadeEquipamento().setText("");

		frm.getCbLigacaoEquipamento().setSelectedIndex(-1);
		frm.getCbPolosEquipamento().setSelectedIndex(-1);
		frm.getCbUnidadePotEquipamento().setSelectedIndex(-1);

		frm.getLblIdEquipamento().setText(null);
	}

	public Equipamento getDadosFrm() {

		equipamento.setFd(Numero.stringToDouble(frm.getTxtFdEquipamento().getText()));
		equipamento.setFp(Numero.stringToDouble(frm.getTxtFpEquipamento().getText()));
		equipamento.setFs(Numero.stringToDouble(frm.getTxtFServicoEquipamento().getText()));
		equipamento.setfSimu(Numero.stringToDouble(frm.getTxtFSimutaneadadeEquipamento().getText()));
		equipamento.setFu(Numero.stringToDouble(frm.getTxtFUtilizacaoEquipamento().getText()));
		equipamento.setDescricao(frm.getTxtLocalEquipamento().getText());
		equipamento.setNome(frm.getTxtNomeEquipamento().getText());
		equipamento.setPerdasReator(Numero.stringToDouble(frm.getTxtPerdasEquipamento().getText()));
		equipamento.setPotencia(Numero.stringToDouble(frm.getTxtPotenciaEquipamento().getText()));
		equipamento.setRendimento(Numero.stringToDouble(frm.getTxtRendimentoEquipamento().getText()));
		equipamento.setQuantidade(Numero.stringToInteger(frm.getTxtQuantidadeEquipamento().getText()));

		equipamento.setLigacao(frm.getCbLigacaoEquipamento().getModel().getSelectedItem().toString());
		equipamento
				.setnPolos(Numero.stringToInteger(frm.getCbPolosEquipamento().getModel().getSelectedItem().toString()));
		equipamento.setId(Numero.stringToInteger(frm.getLblIdEquipamento().getText()));

		return equipamento;
	}

	private void iniciaCbLigacaoEquipamento() {
		frm.getCbLigacaoEquipamento().removeAllItems();
		frm.getCbLigacaoEquipamento().addItem("FN");
		frm.getCbLigacaoEquipamento().addItem("FF");
		frm.getCbLigacaoEquipamento().addItem("FFN");
		frm.getCbLigacaoEquipamento().addItem("FFF");
		frm.getCbLigacaoEquipamento().addItem("FFFN");
		frm.getCbLigacaoEquipamento().setSelectedIndex(0);
	}

	private void iniciaCbPolosEquipamento() {
		frm.getCbPolosEquipamento().removeAllItems();
		frm.getCbPolosEquipamento().addItem("2");
		frm.getCbPolosEquipamento().addItem("4");
		frm.getCbPolosEquipamento().setSelectedIndex(0);
	}

	private void iniciaCbUnidadePotEquipamento() {
		frm.getCbUnidadePotEquipamento().removeAllItems();
		frm.getCbUnidadePotEquipamento().addItem("VA");
		frm.getCbUnidadePotEquipamento().addItem("W");
		frm.getCbUnidadePotEquipamento().addItem("CV");
		frm.getCbUnidadePotEquipamento().addItem("HP");
		frm.getCbUnidadePotEquipamento().addItem("BTU");
		frm.getCbUnidadePotEquipamento().setSelectedIndex(0);
	}

	public void iniciaCbs() {
		iniciaCbLigacaoEquipamento();
		iniciaCbPolosEquipamento();
		iniciaCbUnidadePotEquipamento();
	}

	public void iniciaTabelaEquipamento(Integer idCircuito) {

		List<Equipamento> lista = new ArrayList<Equipamento>();

		if (!(idCircuito == 0)) {

			Circuito circuito = CircuitoService.getById(idCircuito);

			for (Equipamento f : circuito.getEquipamentos()) {
				lista.add(f);
			}
		}
		if (!(lista.isEmpty() || lista == null)) {
			tabela = new GenericTableModel<Equipamento>(lista, Equipamento.class);
			frm.getTableEquipamentos().repaint();
			frm.getTableEquipamentos().setModel(tabela);
			if (tabelaSelecao >= 0) {
				frm.getTableEquipamentos().setRowSelectionInterval(tabelaSelecao, tabelaSelecao);
			}
		} else {
			frm.getTableEquipamentos().repaint();
			frm.getTableEquipamentos().setModel(new DefaultTableModel());
		}
	}

	public void preencheFrm(Equipamento equipamento) {

		if (equipamento != null) {
			this.equipamento = equipamento;

			frm.getTxtFdEquipamento().setText(Numero.decimal(equipamento.getFd(), "##,00"));
			frm.getTxtFpEquipamento().setText(Numero.decimal(equipamento.getFp(), "##,00"));
			frm.getTxtFServicoEquipamento().setText(Numero.decimal(equipamento.getFs(), "##,00"));
			frm.getTxtFSimutaneadadeEquipamento().setText(Numero.decimal(equipamento.getfSimu(), "##,00"));
			frm.getTxtFUtilizacaoEquipamento().setText(Numero.decimal(equipamento.getFu(), "##,00"));
			frm.getTxtLocalEquipamento().setText(equipamento.getDescricao());
			frm.getTxtNomeEquipamento().setText(equipamento.getNome());
			frm.getTxtPerdasEquipamento().setText(Numero.decimal(equipamento.getPerdasReator(), "##,00"));
			frm.getTxtPotenciaEquipamento().setText(Numero.decimal(equipamento.getPotencia(), "##,00"));
			frm.getTxtRendimentoEquipamento().setText(Numero.decimal(equipamento.getRendimento(), "##,00"));
			frm.getTxtQuantidadeEquipamento().setText(Integer.toString(equipamento.getQuantidade()));

			frm.getCbLigacaoEquipamento().getModel().setSelectedItem(equipamento.getLigacao());
			frm.getCbPolosEquipamento().getModel().setSelectedItem(equipamento.getnPolos());

			frm.getLblIdEquipamento().setText(equipamento.getId().toString());
		}
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public GenericTableModel<Equipamento> getTabela() {
		return tabela;
	}

	public void setTabela(GenericTableModel<Equipamento> tabela) {
		this.tabela = tabela;
	}

	public int getTabelaSelecao() {
		return tabelaSelecao;
	}

	public void setTabelaSelecao(int tabelaSelecao) {
		this.tabelaSelecao = tabelaSelecao;
	}
}
