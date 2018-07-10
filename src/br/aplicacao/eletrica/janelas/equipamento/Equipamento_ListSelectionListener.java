package br.aplicacao.eletrica.janelas.equipamento;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Equipamento_ListSelectionListener implements ListSelectionListener {

	public Equipamento_ListSelectionListener() {

	}

	public void add(ListSelectionModel model) {
		model.addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {

		/*
		 * Equipamento equipamento =
		 * tableModel.getEquipamentos().get(frm.getTableEquipamentos().getSelectedRow())
		 * ; EquipamentoToForm.copia(equipamento, frm); Habilitacampos.formu(frm);
		 * frm.getMntmExcluir().setEnabled(true);
		 * frm.getMntmInserir().setEnabled(false); frm.getMntmSalvar().setEnabled(true);
		 * frm.getMntmCancelar().setEnabled(true); frm.getMntmCopiar().setEnabled(true);
		 */

	}

}
