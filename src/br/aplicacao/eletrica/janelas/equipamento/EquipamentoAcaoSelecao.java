package br.aplicacao.eletrica.janelas.equipamento;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Equipamento;
import br.aplicacao.eletrica.uteis.Numero;

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

		int firstIndex = e.getFirstIndex();

		if (firstIndex >= 0 && !(Numero.stringToInteger(frm.getLblIdProjeto().getText()) == null)) {

			Equipamento equipamento = frm.getEquipamentoControle().getTabela().loadItem(firstIndex);
			frm.getEquipamentoControle().preencheFrm(equipamento);
			frm.getEquipamentoControle().setTabelaSelecao(firstIndex);
		}
	}

}
