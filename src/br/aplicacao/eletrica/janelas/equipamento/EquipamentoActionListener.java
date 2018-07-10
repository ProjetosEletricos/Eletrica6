package br.aplicacao.eletrica.janelas.equipamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class EquipamentoActionListener implements ActionListener {

	public EquipamentoActionListener() {

		this.inicializa_TabelaEquipamentos();
		this.adiciona_ActionListener();
		this.adiciona_ListSelectionListener();
		this.adiciona_KeyListener();

	}

	@Override
	public void actionPerformed(ActionEvent event) {

	}

	protected void adiciona_ActionListener() {

		/*
		 * frm.getMntmExcluir().addActionListener(this);
		 * frm.getMntmInserir().addActionListener(this);
		 * frm.getMntmSalvar().addActionListener(this);
		 * frm.getMntmCancelar().addActionListener(this);
		 * frm.getMntmCopiar().addActionListener(this);
		 */

	}

	private void adiciona_KeyListener() {

	}

	private void adiciona_ListSelectionListener() {

	}

	public void filtraUmEquipamento(HashMap<Object, Object> filtro) {

		/*
		 * limpaTabela(); this.equipamentos = service.getEquipamentos(filtro);
		 * 
		 * this.tableModel.setEquipamentos(equipamentos);
		 * frm.getTableEquipamentos().setModel(this.tableModel);
		 * 
		 * frm.getTableEquipamentos().updateUI(); //
		 * frm.getTableEquipamentos().selectAll();
		 * frm.getMntmExcluir().setEnabled(true);
		 * frm.getMntmInserir().setEnabled(false); frm.getMntmSalvar().setEnabled(true);
		 * frm.getMntmCancelar().setEnabled(false);
		 * frm.getMntmCopiar().setEnabled(false);
		 */

	}

	private void inicializa_TabelaEquipamentos() {

	}

	public void limpaTabela() {

	}

}
