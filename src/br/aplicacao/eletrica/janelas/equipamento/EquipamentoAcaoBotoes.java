package br.aplicacao.eletrica.janelas.equipamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.Circuito;
import br.aplicacao.eletrica.modelo.Equipamento;
import br.aplicacao.eletrica.servico.CircuitoService;
import br.aplicacao.eletrica.servico.EquipamentoService;
import br.aplicacao.eletrica.uteis.Numero;

public class EquipamentoAcaoBotoes implements ActionListener {

	private PrincipalFrm frm;

	public EquipamentoAcaoBotoes(PrincipalFrm frm) {

		this.frm = frm;
		this.adicionaActionListener();
	}

	private void adicionaActionListener() {

		frm.getBtnCopiarEquipamento().addActionListener(this);
		frm.getBtnExcluirEquipamento().addActionListener(this);
		frm.getBtnSalvarEquipamento().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == frm.getBtnExcluirEquipamento()) {

			Circuito circuito = frm.getCircuitoControle().getCircuito();
			Equipamento equipamento = frm.getEquipamentoControle().getEquipamento();
			circuito.getEquipamentos().remove(equipamento);
			EquipamentoService.remove(equipamento);
			equipamento.apagar();

			frm.getTableEquipamentos().clearSelection();
			frm.getEquipamentoControle().iniciaTabelaEquipamento(circuito.getEquipamentos());
			frm.getEquipamentoControle().apagaDadosFrm();

		} else if (event.getSource() == frm.getBtnSalvarEquipamento()) {

			this.salvar();

		} else if (event.getSource() == frm.getBtnCopiarEquipamento()) {

			frm.getLblIdEquipamento().setText(null);
			this.salvar();

		}
	}

	private void salvar() {

		if (Integer.valueOf(frm.getLblIdCircuito().getText()) > 0) {

			Circuito circuito = CircuitoService.getById(Numero.stringToInteger(frm.getLblIdCircuito().getText(), 0));
			Equipamento equipamento = frm.getEquipamentoControle().getDadosFrm();

			if (equipamento.getId() == null) {
				circuito.getEquipamentos().add(equipamento);
				EquipamentoService.salva(equipamento);
			} else {
				EquipamentoService.salva(equipamento);
			}
			frm.getEquipamentoControle().apagaDadosFrm();
			frm.getEquipamentoControle().setTabelaSelecao(-1);
			frm.getEquipamentoControle().iniciaTabelaEquipamento(circuito.getEquipamentos());
		}
	}
}
