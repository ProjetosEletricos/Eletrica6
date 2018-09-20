package br.aplicacao.eletrica.janelas.equipamento;

import java.util.ArrayList;
import java.util.List;

import br.aplicacao.eletrica.enums.Ligacao;
import br.aplicacao.eletrica.enums.UnidadePontencia;
import br.aplicacao.eletrica.enums.Usabilidade;
import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.Equipamento;
import br.aplicacao.eletrica.uteis.Numero;
import br.aplicacao.eletrica.uteis.TrataID;
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
		frm.getCbUsabilidadeEquipamento().setSelectedIndex(-1);
		frm.getCbLigacaoEquipamento().setSelectedIndex(-1);
		frm.getCbPolosEquipamento().setSelectedIndex(-1);
		frm.getCbUnidadePotEquipamento().setSelectedIndex(-1);

		frm.getLblIdEquipamento().setText("0");
	}

	public Equipamento getDadosFrm() {

		Equipamento equipamento = new Equipamento();

		equipamento.setFd(Numero.stringToDouble(frm.getTxtFdEquipamento().getText(), 1));
		equipamento.setFp(Numero.stringToDouble(frm.getTxtFpEquipamento().getText(), 1));
		equipamento.setFs(Numero.stringToDouble(frm.getTxtFServicoEquipamento().getText(), 1));
		equipamento.setfSimu(Numero.stringToDouble(frm.getTxtFSimutaneadadeEquipamento().getText(), 1));
		equipamento.setFu(Numero.stringToDouble(frm.getTxtFUtilizacaoEquipamento().getText(), 1));
		equipamento.setDescricao(frm.getTxtLocalEquipamento().getText());
		equipamento.setNome(frm.getTxtNomeEquipamento().getText());
		equipamento.setPerdasReator(Numero.stringToDouble(frm.getTxtPerdasEquipamento().getText(), 0));
		equipamento.setPotencia(Numero.stringToDouble(frm.getTxtPotenciaEquipamento().getText(), 0));
		equipamento.setRendimento(Numero.stringToDouble(frm.getTxtRendimentoEquipamento().getText(), 1));
		equipamento.setQuantidade(Numero.stringToInteger(frm.getTxtQuantidadeEquipamento().getText(), 1));
		equipamento.setUnidade(
				frm.getCbUnidadePotEquipamento().getItemAt(frm.getCbUnidadePotEquipamento().getSelectedIndex()));
		equipamento.setUsabilidade(
				frm.getCbUsabilidadeEquipamento().getItemAt(frm.getCbUsabilidadeEquipamento().getSelectedIndex()));
		equipamento
				.setLigacao(frm.getCbLigacaoEquipamento().getItemAt(frm.getCbLigacaoEquipamento().getSelectedIndex()));
		equipamento.setnPolos(
				Numero.stringToInteger(frm.getCbPolosEquipamento().getModel().getSelectedItem().toString(), 4));
		equipamento.setId(TrataID.StringToInteger(frm.getLblIdEquipamento().getText()));
		equipamento.setCircuito(frm.getCircuitoControle().getCircuito());

		this.equipamento = equipamento;
		return equipamento;
	}

	private void iniciaCbPolosEquipamento() {
		frm.getCbPolosEquipamento().removeAllItems();
		frm.getCbPolosEquipamento().addItem("2");
		frm.getCbPolosEquipamento().addItem("4");
		frm.getCbPolosEquipamento().setSelectedIndex(0);
	}

	private void iniciaCbUnidadePotEquipamento() {
		List<UnidadePontencia> lista = new ArrayList<UnidadePontencia>();
		frm.getCbUnidadePotEquipamento().removeAllItems();
		lista.add(UnidadePontencia.BTU);
		lista.add(UnidadePontencia.CV);
		lista.add(UnidadePontencia.HP);
		lista.add(UnidadePontencia.VA);
		lista.add(UnidadePontencia.W);
		frm.setUnidadeEquipamento(lista);
	}
	
	private void iniciaCbLigacaoEquipamento() {
		List<Ligacao> lista = new ArrayList<Ligacao>();
		frm.getCbLigacaoEquipamento().removeAllItems();
		lista.add(Ligacao.FF);
		lista.add(Ligacao.FFN);
		lista.add(Ligacao.FFF);
		lista.add(Ligacao.FFFN);
		lista.add(Ligacao.FN);
		frm.setLigacaoEquipamento(lista);
	}
	
	private void iniciaCbUsabilidadeEquipamento() {
		List<Usabilidade> lista = new ArrayList<Usabilidade>();
		frm.getCbUsabilidadeEquipamento().removeAllItems();
		lista.add(Usabilidade.ILUMINACAO_FLUORESCENTE);
		lista.add(Usabilidade.ILUMINACAO_INCADESCENTE);
		lista.add(Usabilidade.MOTOR);
		lista.add(Usabilidade.EQUIPAMENTOS_ESPECIAIS);
		lista.add(Usabilidade.GERAL);
		frm.setUsabilidadeEquipamento(lista);
	}

	public void iniciaCbs() {
		iniciaCbLigacaoEquipamento();
		iniciaCbPolosEquipamento();
		iniciaCbUnidadePotEquipamento();
		iniciaCbUsabilidadeEquipamento();
	}

	public void iniciaTabelaEquipamento(List<Equipamento> lista) {

		try {
			tabela = new GenericTableModel<Equipamento>(lista, Equipamento.class);
			frm.getTableEquipamentos().setModel(tabela);
			frm.getTableEquipamentos().setRowSelectionInterval(tabelaSelecao, tabelaSelecao);

		} catch (Exception e) {

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
			frm.getCbUsabilidadeEquipamento().getModel().setSelectedItem(equipamento.getUsabilidade());
			frm.getCbLigacaoEquipamento().getModel().setSelectedItem(equipamento.getLigacao());
			frm.getCbPolosEquipamento().getModel().setSelectedItem(equipamento.getnPolos());
			frm.getCbUnidadePotEquipamento().getModel().setSelectedItem(equipamento.getUnidade());
			frm.getLblIdEquipamento().setText(Integer.toString(equipamento.getId()));
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
