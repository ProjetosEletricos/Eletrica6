package br.aplicacao.eletrica.janelas.equipamento;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Equipamento;

public class EquipamentoAcaoSelecao implements ListSelectionListener {

	private PrincipalFrm frm;

	public EquipamentoAcaoSelecao(PrincipalFrm frm) {

		this.frm = frm;
		this.AdicionarListSelectionListener();
	}

	private void AdicionarListSelectionListener() {

		frm.getTableEquipamentos().getSelectionModel().addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (e.getFirstIndex() >= 0 && e.getValueIsAdjusting() == true && frm.getTableEquipamentos().getSelectedRow() >= 0) {

			int linha = frm.getTableEquipamentos().getSelectedRow();
			Equipamento equipamento = frm.getEquipamentoControle().getTabela().loadItem(linha);
			frm.getEquipamentoControle().preencheFrm(equipamento);
			frm.getEquipamentoControle().setTabelaSelecao(linha);
		}
	}
}
