package br.aplicacao.eletrica.janelas.equipamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Circuito;
import br.aplicacao.eletrica.modelo.projeto.Equipamento;
import br.aplicacao.eletrica.servico.CircuitoService;
import br.aplicacao.eletrica.servico.EquipamentoService;
import br.aplicacao.eletrica.uteis.Numero;

public class EquipamentoAcaoBotoes implements ActionListener {

	private PrincipalFrm frm;

	public EquipamentoAcaoBotoes(PrincipalFrm frm) {

		this.frm = frm;
		this.adicionaActionListener();
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == frm.getBtnExcluirEquipamento()) {

			Circuito circuito = frm.getCircuitoControle().getCircuito();
			Equipamento equipamento = frm.getEquipamentoControle().getEquipamento();
			circuito.getEquipamentos().remove(equipamento);
			EquipamentoService.remove(equipamento);

			frm.getEquipamentoControle().setTabelaSelecao(-1);
			frm.getEquipamentoControle()
					.iniciaTabelaEquipamento(Numero.stringToInteger(frm.getLblIdCircuito().getText()));
			frm.getEquipamentoControle().apagaDadosFrm();

		} else if (event.getSource() == frm.getBtnSalvarEquipamento()) {

			this.salvar();

		} else if (event.getSource() == frm.getBtnCopiarEquipamento()) {

			frm.getLblIdEquipamento().repaint();
			this.salvar();

		}
	}

	private void adicionaActionListener() {

		frm.getBtnCopiarEquipamento().addActionListener(this);
		frm.getBtnExcluirEquipamento().addActionListener(this);
		frm.getBtnSalvarEquipamento().addActionListener(this);

	}

	private void salvar() {

		if (Numero.stringToInteger(frm.getLblIdProjeto().getText()) > 0) {
			Circuito circuito = CircuitoService.getById(Numero.stringToInteger(frm.getLblIdCircuito().getText()));
			Equipamento equipamento = frm.getEquipamentoControle().getDadosFrm();

			if (Numero.stringToInteger(frm.getLblIdEquipamento().getText()) == null) {
				circuito.getEquipamentos().add(equipamento);
				EquipamentoService.salva(equipamento);
			} else {
				EquipamentoService.salva(equipamento);
			}
			frm.getEquipamentoControle()
					.iniciaTabelaEquipamento(Numero.stringToInteger(frm.getLblIdCircuito().getText()));
		}
	}
}
